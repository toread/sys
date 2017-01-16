package com.toread.sys.service;

import com.toread.sys.common.tree.service.SimpleTreeService;
import com.toread.sys.entity.Department;

/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService extends SimpleTreeService<Department> {
    String TREE_KEY = "DEPARTMENT_TREE";
}