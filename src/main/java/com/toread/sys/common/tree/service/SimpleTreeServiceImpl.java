package com.toread.sys.common.tree.service;

import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.toread.sys.common.tree.SimpleTree;
import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.common.tree.TreeUtils;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.config.CacheConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author toread
 */
public abstract class SimpleTreeServiceImpl<M extends AutoMapper<T>,T> extends SuperServiceImpl<M, T>  implements SimpleTreeService<T> {

    @Autowired
    private CacheManager cacheManager;

    protected  abstract Class<T> getEntityClass();
    protected  abstract String keyName();
    protected  abstract Object rootId();

    @Override
    public boolean addTreeNode(T t) {
        Object pId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
        Object id = TreeUtils.getAnnotationFieldValues(t, TreeId.class);
        Assert.notNull(pId,"PID值为空");
        Assert.notNull(findFather(id),String.format("未找到%s节点",id));
        return insert(t);
    }

    /**
     * 创建根节点
     * @param t
     */
    protected void insertRootNode(T t){
        int count = this.selectCount(new EntityWrapper<T>());
        if(count ==0){
            TreeUtils.setAnnotationFieldValue(t,TreeId.class,keyName());
            this.insert(t);
        }
    }

    @Override
    public boolean deleteTreeNode(T t) {
        Object pId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
        Object id = TreeUtils.getAnnotationFieldValues(t, TreeId.class);
        Assert.notNull(pId,"PID值为空");
        Assert.notNull(findFather(pId),String.format("未找到%s节点",id));
        return false;
    }

    @Override
    public Tree<T> buildTree() {
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        Tree<T> tree = cache.get(keyName(),Tree.class);
        if(tree == null){
            tree = new SimpleTree<T>();
            tree.buildTree(this.selectList(new EntityWrapper<T>()),rootId());
            cache.put(keyName(),tree);
        }
        return  tree;
    }

    @Override
    public List<T> findChildes(Object depId) {
        Assert.notNull(depId,"节点ID不能为空");
        T t = BeanUtils.instantiate(getEntityClass());
        TreeUtils.setAnnotationFieldValue(t,TreeId.class,depId);
        TreeNode<T> departmentTreeNode = buildTree().findTreeNode(t);
        return CollectionUtils.arrayToList(TreeUtils.getTreeChildesData(departmentTreeNode).toArray());
    }

    @Override
    public T findFather(Object depId) {
        Assert.notNull(depId,"节点ID不能为空");
        T t = BeanUtils.instantiate(getEntityClass());
        TreeUtils.setAnnotationFieldValue(t,TreeId.class,depId);
        return (T) buildTree().findTreeNode(t).getFather().getData();
    }
}
