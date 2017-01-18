package com.toread.sys.common.tree;

import com.toread.sys.common.Check;
import com.toread.sys.common.tree.annotation.TreeId;
import com.toread.sys.common.tree.annotation.TreePid;
import com.toread.sys.common.tree.annotation.TreeText;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
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
            Check.notNull(id,"树Id不能为空");Check.notNull(fatherId,"树Pid不能为空");
            Check.isTrue(id.equals(fatherId),"树Id不能等于树Pid");
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
        Check.notNull(id,"树ID不能为空");
        Iterator<TreeNode<T>> iterable = childesNode.iterator();
        while (iterable.hasNext()){
            TreeNode<T> tTreeNode = iterable.next();
            Object tagId = TreeUtils.getAnnotationFieldValues(tTreeNode.getData(),TreeId.class);
            Check.notNull(tagId,"树ID不能为空");
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

    @Override
    public String treePath() {
        ArrayList list = new ArrayList();
        String thisNodeText = TreeUtils.getAnnotationFieldValues(this.getData(), TreeText.class).toString();
        list.add(thisNodeText);
        TreeNode<T> father = this.getFather();
        while (father!=null){
            list.add(TreeUtils.getAnnotationFieldValues(father.getData(), TreeText.class).toString());
            father = father.getFather();
        }
        //处理数据结构
        Collections.reverse(list);
        return StringUtils.arrayToDelimitedString(list.toArray(),"/");
    }
}
