package com.toread.sys.service;

import com.toread.sys.entity.Department;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * Department 表数据服务层接口
 *
 */
public interface IDepartmentService extends ISuperService<Department> {
    /**
     * 获取节点部门
     * @param depId
     * @return
     */
    List<Department> findChildes(String depId);

    /**
     * 获取父亲节点
     * @param depId
     * @return
     */
    Department findFather(String depId);


}