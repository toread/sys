package com.toread.sys.common.tree;

import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author toread
 */
public class SimpleTreeNode<T> implements TreeNode<T> {
    protected T data;
    protected TreeNode<T> fatherNode;
    protected List<TreeNode<T>> childesNode;

    public SimpleTreeNode() {
        childesNode = new ArrayList<TreeNode<T>>();
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T t){
        TreeNode<T> father = this.getFather();
        if(father==null){
            data = t;
        }else {
            Object id = TreeUtils.getAnnotationFieldValues(father.getData(), TreeId.class);
            Object fatherId = TreeUtils.getAnnotationFieldValues(t, TreePid.class);
            Assert.notNull(id);Assert.notNull(fatherId);
            Assert.isTrue(id.equals(fatherId));
            data = t;
        }
    }

    @Override
    public TreeNode addChild(T t) {
        SimpleTreeNode<T> childNode = new SimpleTreeNode<T>();
        childNode.setFather(this);
        childNode.setData(t);
        childesNode.add(childNode);
        return childNode;
    }

    @Override
    public TreeNode removeChild(T t) {
        if(CollectionUtils.isEmpty(childesNode)){return  null;}
        Object id = TreeUtils.getAnnotationFieldValues(t,TreeId.class);
        Assert.notNull(id);
        Iterator<TreeNode<T>> iterable = childesNode.iterator();
        while (iterable.hasNext()){
            TreeNode<T> tTreeNode = iterable.next();
            Object tagId = TreeUtils.getAnnotationFieldValues(tTreeNode.getData(),TreeId.class);
            Assert.notNull(tagId);
            if(tagId.equals(id)){return tTreeNode;}
        }
        return null;
    }

    @Override
    public void setFather(TreeNode<T> t) {
        this.fatherNode = t;
    }

    @Override
    public TreeNode getFather() {
        return this.fatherNode;
    }

    @Override
    public List<TreeNode<T>> getChildes() {
        return this.childesNode;
    }

    @Override
    public Boolean isLeaf() {
        return CollectionUtils.isEmpty(childesNode);
    }
}
