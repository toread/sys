package com.toread.sys.service.impl;

import com.toread.sys.common.enums.State;
import org.springframework.stereotype.Service;

import com.toread.sys.mapper.RoleMapper;
import com.toread.sys.entity.Role;
import com.toread.sys.service.IRoleService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.util.Assert;

import java.util.List;

/**
 *
 * Role 表数据服务层接口实现类
 *
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> queryUserRole(Long userId, State state) {
        Assert.notNull(userId);Assert.notNull(state);
        return baseMapper.queryUserRole(userId,state.getCode());
    }
}