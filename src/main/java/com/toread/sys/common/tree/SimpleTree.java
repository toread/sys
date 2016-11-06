package com.toread.sys.common.tree;

import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import org.springframework.util.Assert;

import java.util.*;

import static com.toread.sys.common.tree.TreeUtils.getAnnotationFieldValues;

/**
 *
 * @author toread
 */
public class SimpleTree<T> implements Tree<T> {
    protected  List<T> treeData;
    protected  TreeNode<T> rootNode;

    @Override
    public void buildTree(Collection<T> trees, Object rootId) {
        Assert.notEmpty(trees);
        T t = findRoot(trees,rootId);
        TreeNode<T> rootNode = new SimpleTreeNode<T>();
        rootNode.setData(t);
        this.rootNode = rootNode;
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
        Collection<TreeNode<T>> childs = node.getChildes();
        for (TreeNode<T> child : childs) {
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


    /**
     *
     * @param tList
     * @return
     */
    private static <T> T findRoot(Collection<T> tList, Object rootId){
        for (T t : tList) {
            Object id = getAnnotationFieldValues(t,TreeId.class);
            if(rootId.equals(id)){return t;}
        }
        String errorMsg = "未找到含有"+rootId+"根节点";
        throw  new TreeException(errorMsg);
    }


    @Override
    public TreeNode<T> getRoot() {
        return this.rootNode;
    }

    @Override
    public TreeNode<T> findTreeNode(T t) {
        if(isTreeNodeData(t,rootNode)){
            return rootNode;
        }else {
            return findChild(rootNode,t);
        }
    }

    private TreeNode<T> findChild(TreeNode<T> node,T t){
        Collection<TreeNode<T>> childes = node.getChildes();
        for (TreeNode<T> child : childes) {
            if(isTreeNodeData(t,child)){
                return child;
            }else {
                findChild(child,t);
            }
        }
        return null;
    }

    private boolean isTreeNodeData(T t,TreeNode<T> treeNode){
        Object id = getAnnotationFieldValues(t,TreeId.class);
        Object tagId = getAnnotationFieldValues(treeNode.getData(),TreeId.class);
        return  (tagId.equals(id));

    }

    @Override
    public TreeNode<T> removeTreeNode(T t) {
        TreeNode<T>  node = findChild(rootNode,t);
        Assert.isTrue(!node.equals(rootNode));
        node.getFather().getChildes().remove(node);
        return node;
    }

    @Override
    public List<T> getTreeData() {
        return Collections.unmodifiableList(treeData);
    }

}
