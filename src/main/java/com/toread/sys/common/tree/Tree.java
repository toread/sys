package com.toread.sys.common.tree;

import com.toread.sys.entity.Department;

import java.util.Collection;
import java.util.List;

/**
 * <h1>对整颗树进行抽象</h1>
 * <p>
 *     树的构建,查找,删除
 * </p>
 * @author toread
 */
public interface Tree<T> {
    /**
     * 构建树
     * @param trees 集合
     * @return
     */
    void buildTree(Collection<T> trees,Object rootId);

    /**
     * 获取树根节点
     * @return
     */
    TreeNode<T> getRoot();

    /**
     * 根据对象获取属性结构
     * @param t
     * @return
     */
    TreeNode<T> findTreeNode(T t);

    /**
     * 删除树节点
     * @param t
     * @return
     */
    TreeNode<T> removeTreeNode(T t);

    /**
     * 获取目前树所有对象
     * @return
     */
    List<T> getTreeData();

}
