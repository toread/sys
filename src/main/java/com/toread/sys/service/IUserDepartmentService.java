package com.toread.sys.service;

import com.toread.sys.entity.UserDepartment;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * UserDepartment 表数据服务层接口
 *
 */
public interface IUserDepartmentService extends ISuperService<UserDepartment> {

    /**
     * 绑定部门
     * @param userId
     * @param dptId
     * @return
     */
    boolean bindUser(Long userId,Long dptId);

    /**
     * 解绑部门
     * @param userId
     * @param dptId
     * @return
     */
    boolean unBindUser(Long userId,Long dptId);
}