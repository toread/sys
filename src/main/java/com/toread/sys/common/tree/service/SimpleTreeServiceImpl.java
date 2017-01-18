package com.toread.sys.common.tree.service;

import com.toread.sys.common.Check;
import com.toread.sys.common.mybatis.CRUDMapper;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.tree.SimpleTree;
import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.common.tree.TreeUtils;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.config.CacheConfig;
import com.toread.sys.utils.MonitorUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author toread
 */
public abstract class SimpleTreeServiceImpl<M extends CRUDMapper<T>,T> extends SimpleBaseService<M,T,Long> implements SimpleTreeService<T> {

    @Autowired
    private CacheManager cacheManager;

    protected  abstract Class<T> getEntityClass();
    protected  abstract String keyName();
    protected  abstract Object rootId();

    protected void clearTreeCache(){
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        cache.evict(keyName());
    }

    @Override
    public boolean addTreeNode(T t) {
        //判断数据库是否有节点
        T root = BeanUtils.instantiate(getEntityClass());
        TreeUtils.setAnnotationFieldValue(root,TreeId.class,rootId());
        T fromDBRoot = selectOne(root);
        if(fromDBRoot==null){
            TreeUtils.setAnnotationFieldValue(t,TreeId.class,rootId());
        }else{
            Object pId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
            Check.notNull(pId,"PID值为空");
            T father = BeanUtils.instantiate(getEntityClass());
            TreeUtils.setAnnotationFieldValue(father,TreeId.class,pId);
            Check.notNull(buildTree().findTreeNode(father),String.format("未找到%s节点",pId));
        }
        return insert(t);
    }

    /**
     * 创建根节点
     * @param t
     */
    protected void insertRootNode(T t){
        int count = selectAll().size();
        if(count ==0){
            TreeUtils.setAnnotationFieldValue(t,TreeId.class,keyName());
            this.insert(t);
        }
    }

    @Override
    public boolean updateTreeNode(T t){
        Object pId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
        Object id = TreeUtils.getAnnotationFieldValues(t, TreeId.class);
        Check.notNull(pId,"PID值为空");
        Check.notNull(findFather(pId),String.format("未找到%s节点",pId));
        Check.notNull(findFather(id),String.format("未找到%s节点",id));
        clearTreeCache();
        updateSelectiveById(t);
        return  false;
    }

    @Override
    public boolean deleteTreeNode(T t) {
        Object pId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
        Check.notNull(pId,"PID值为空");
        Check.notNull(findFather(pId),String.format("未找到%s节点",pId));
        return false;
    }

    @Override
    public Tree<T> buildTree() {
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        Tree<T> tree = cache.get(keyName(),Tree.class);
        if(tree == null){
            tree = new SimpleTree<T>();
            Long begin = MonitorUtils.timeNow();
            tree.buildTree(this.selectAll(),rootId());
            MonitorUtils.idleLogger(begin);
            cache.put(keyName(),tree);
        }
        return  tree;
    }

    @Override
    public List<T> findChildes(Object depId) {
        Check.notNull(depId,"节点ID不能为空");
        T t = BeanUtils.instantiate(getEntityClass());
        TreeUtils.setAnnotationFieldValue(t,TreeId.class,depId);
        TreeNode<T> departmentTreeNode = buildTree().findTreeNode(t);
        Check.notNull(departmentTreeNode,String.format("未找到%s节点",depId));
        return CollectionUtils.arrayToList(TreeUtils.getTreeChildesData(departmentTreeNode).toArray());
    }

    @Override
    public T findFather(Object depId) {
        //判断是否根节点
        if(rootId().equals(depId)){
            return  buildTree().getRoot().getData();
        }
        Check.notNull(depId,"节点ID不能为空");
        T t = BeanUtils.instantiate(getEntityClass());
        TreeUtils.setAnnotationFieldValue(t,TreeId.class,depId);
        TreeNode<T> treeNode = buildTree().findTreeNode(t);
        Check.notNull(treeNode,String.format("未找到%s节点",depId));
        return (T) buildTree().findTreeNode(t).getFather().getData();
    }
}
