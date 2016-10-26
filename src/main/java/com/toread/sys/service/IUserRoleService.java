package com.toread.sys.service;

import com.toread.sys.entity.UserRole;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * UserRole 表数据服务层接口
 *
 */
public interface IUserRoleService extends ISuperService<UserRole> {
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