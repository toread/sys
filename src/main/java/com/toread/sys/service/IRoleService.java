package com.toread.sys.service;

import com.github.pagehelper.PageInfo;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.BaseService;
import com.toread.sys.entity.Role;

import java.util.List;

/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService extends BaseService<Role,Long> {
    /**
     * 获取用户
     * @param role
     * @return
     */
    List<Role> queryRoleRole(Role role, PageInfo pageInfo);

    /**
     * 增加角色
     * @param role
     * @param departmentId
     */
    void addRole(Role role,Long departmentId);

    /**
     * 删除角色
     * @param role
     */
    void deleteRole(Role role);
}