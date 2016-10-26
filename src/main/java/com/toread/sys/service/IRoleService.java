package com.toread.sys.service;

import com.toread.sys.common.enums.State;
import com.toread.sys.entity.Role;
import com.baomidou.framework.service.ISuperService;

import java.util.List;

/**
 *
 * Role 表数据服务层接口
 *
 */
public interface IRoleService extends ISuperService<Role> {
    /**
     * 获取用户
     * @param userId
     * @return
     */
    List<Role> queryUserRole(Long userId, State state);

}