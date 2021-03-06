package com.toread.sys.service;

import com.toread.sys.common.service.BaseService;
import com.toread.sys.entity.UserRole;

/**
 *
 * UserRole 表数据服务层接口
 *
 */
public interface IUserRoleService extends BaseService<UserRole,Long> {
    /**
     * 绑定角色
     * @param userId
     * @param roleId
     * @return
     */
    boolean bindRole(Long userId,Long roleId);

    /**
     * 解除角色
     * @param userId
     * @param roleId
     * @return
     */
    boolean unBindRole(Long userId,Long roleId);
}