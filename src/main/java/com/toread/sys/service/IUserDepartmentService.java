package com.toread.sys.service;

import com.toread.sys.common.service.BaseService;
import com.toread.sys.entity.UserDepartment;

import java.util.List;

/**
 *
 * UserDepartment 表数据服务层接口
 *
 */
public interface IUserDepartmentService extends BaseService<UserDepartment,Long> {

    /**
     * 绑定部门
     * @param userId
     * @param dptId
     * @return
     */
    boolean bindDepartment(Long userId, List<Long> dptId);

    /**
     * 解绑部门
     * @param userId
     * @param dptId
     * @return
     */
    boolean unBindDepartment(Long userId, List<Long> dptId);

}