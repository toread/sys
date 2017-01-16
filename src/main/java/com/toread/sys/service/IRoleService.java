package com.toread.sys.service;

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
     * @param userId
     * @return
     */
    List<Role> queryUserRole(Long userId, State state);

}