package com.toread.sys.service;

import com.github.pagehelper.Page;
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
     * 角色查询
     * @param role
     * @return
     */
    Page<Role> queryRole(Role role, PageInfo pageInfo);

    /**
     * 增加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 删除角色
     * @param role
     */
    void deleteRole(Role role);


    /**
     * 更新用户
     */
    Integer updateRole(Role role);

    /**
     * 查询用户角色
     * @param userId
     * @param state
     * @return
     */
    List<Role>  queryUserRole(Long userId,State state);
}