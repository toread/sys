package com.toread.sys.service;

import com.toread.sys.common.tree.Tree;
import com.toread.sys.entity.Department;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService extends ISuperService<Department> {

    String TREE_KEY = "department_tree";

    /**
     * 增加机构
     * @param department
     * @return
     */
    boolean addDepartment(Department department);

    /**
     * 删除机构
     * @param department
     * @return
     */
    boolean deleteDepartment(Department department);
    /**
     * 获取节点部门
     * @param depId
     * @return
     */
    List<Department> findChildes(Long depId);

    /**
     * 获取父亲节点
     * @param depId
     * @return
     */
    Department findFather(Long depId);


    /**
     * 构建机构树
     */
    Tree<Department> buildDepartmentTree();
}