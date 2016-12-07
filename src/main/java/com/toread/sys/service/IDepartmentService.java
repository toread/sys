package com.toread.sys.service;

import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.service.SimpleTreeService;
import com.toread.sys.entity.Department;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService extends SimpleTreeService<Department> {

    String TREE_KEY = "DEPARTMENT_TREE";
}