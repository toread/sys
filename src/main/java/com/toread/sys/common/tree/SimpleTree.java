package com.toread.sys.common.tree;

import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.common.validator.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static com.toread.sys.common.tree.TreeUtils.getAnnotationFieldValues;

/**
 *
 * @author toread
 */
public class SimpleTree<T> implements Tree<T> {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTree.class);
    protected  List<T> treeData;
    protected  TreeNode<T> rootNode;

    /**
     * @param tList
     * @return
     */
    private static <T> T findRoot(Collection<T> tList, Object rootId) {
        for (T t : tList) {
            Object id = getAnnotationFieldValues(t, TreeId.class);
            if (rootId.equals(id)) {
                return t;
            }
        }
        String errorMsg = "未找到含有" + rootId + "根节点";
        throw new TreeException(errorMsg);
    }

    @Override
    public synchronized void  buildTree(Collection<T> trees, Object rootId) {
        Check.notEmpty(trees,"构建树集合不能为空");
        T t = findRoot(trees,rootId);
        TreeNode<T> rootNode = new SimpleTreeNode<T>();
        rootNode.setData(t);
        this.rootNode = rootNode;
        //先移除根节点
        trees.remove(t);
        buildChildesNode(rootId,trees,rootNode);
        treeData = buildTreeData();
    }

    private List<T> buildTreeData(){
        List<T> data = new ArrayList<T>(512);
        data.add(rootNode.getData());
        addChildData(data,rootNode);
        return data;
    }

    private void addChildData(Collection<T> data,TreeNode<T> node) {
        Collection<TreeNode<T>> childes = node.getChildes();
        for (TreeNode<T> child : childes) {
            data.add(child.getData());
            addChildData(data,child);
        }
    }

    private  <T> void buildChildesNode(Object id, Collection<T> copyList, TreeNode<T> node) {
        List<T> newList = new ArrayList<T>(copyList);
        Iterator<T> iterable = newList.iterator();
        while (iterable.hasNext()){
            T t1 = iterable.next();
            Object nodePid = getAnnotationFieldValues(t1, TreePid.class);
            Object nodeId = getAnnotationFieldValues(node.getData(), TreeId.class);
            if(nodeId.equals(nodePid)){
                buildChildesNode(nodeId,newList,node.addChild(t1));
            }
        }
    }

    @Override
    public TreeNode<T> getRoot() {
        return this.rootNode;
    }

    @Override
    public TreeNode<T> findTreeNode(T t) {
        return findNode(rootNode,t);
    }

    private TreeNode<T> findNode(TreeNode<T> node,T t){
        Queue<TreeNode<T>> queue = new ArrayDeque<>(getTreeData().size());
        queue.add(node);
        queue = makerQueue(node,queue);
        TreeNode nodes = null;
        while ((nodes = queue.poll())!=null){
            if(isTreeNodeData((T) nodes.getData(),t)){
                return  nodes;
            }
        }
        return  null;
    }

    private Queue<TreeNode<T>> makerQueue(TreeNode<T> node,Queue<TreeNode<T>> queue){
        List<TreeNode<T>> childes = node.getChildes();
        if(!CollectionUtils.isEmpty(childes)){
            for (TreeNode<T> child : childes) {
                queue.add(child);
                makerQueue(child,queue);
            }
        }
        return queue;
    }

    private boolean isTreeNodeData(T t,T nodeData){
        Object id = getAnnotationFieldValues(t,TreeId.class);
        Object tagId = getAnnotationFieldValues(nodeData,TreeId.class);
        Boolean isTreeNode =   (tagId.equals(id));
        return  isTreeNode;
    }

    @Override
    public TreeNode<T> removeTreeNode(T t) {
        TreeNode<T>  node = findNode(rootNode,t);
        Check.isTrue(!node.equals(rootNode),"根节点树不能被移除");
        node.getFather().getChildes().remove(node);
        return node;
    }

    @Override
    public List<T> getTreeData() {
        return Collections.unmodifiableList(treeData);
    }

}
