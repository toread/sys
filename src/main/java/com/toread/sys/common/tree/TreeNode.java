package com.toread.sys.common.tree;

import java.util.List;

/**
 *
 * @author toread
 */
public interface TreeNode<T> {
    T getData();
    void setData(T t);
    TreeNode addChild(T t);
    TreeNode removeChild(T t);
    void setFather(TreeNode<T> t);
    TreeNode  getFather();
    List<TreeNode<T>> getChildes();
    Boolean isLeaf();
    String treePath();
}
