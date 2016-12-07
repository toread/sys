package com.toread.sys.common.tree.service;

import com.baomidou.framework.service.IService;
import com.toread.sys.common.tree.Tree;

import java.util.List;

/**
 * @author toread
 */
public interface SimpleTreeService<T> extends IService<T, Long> {
    /**
     * 增加树节点
     * @param t
     * @return
     */
    boolean addTreeNode(T t);

    /**
     * 删除树节点
     */
    boolean deleteTreeNode(T t);

    /**
     * 构建树结构
     * @return
     */
    Tree<T> buildTree();

    /**
     * 获取节点部门
     * @param depId
     * @return
     */
    List<T> findChildes(Object depId);

    /**
     * 获取父亲节点
     * @param depId
     * @return
     */
    T findFather(Object depId);

}
