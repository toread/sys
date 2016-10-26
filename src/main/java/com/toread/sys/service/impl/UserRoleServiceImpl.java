package com.toread.sys.service.impl;

import com.toread.sys.service.IRoleService;
import com.toread.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toread.sys.mapper.UserRoleMapper;
import com.toread.sys.entity.UserRole;
import com.toread.sys.service.IUserRoleService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.util.Assert;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends SuperServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public boolean bindRole(Long userId, Long roleId) {
        Assert.notNull(userId);Assert.notNull(roleId);
        Assert.notNull(userService.selectById(userId));
        Assert.notNull(roleService.selectById(roleId));
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return insert(userRole);
    }

    @Override
    public boolean unBindRole(Long userId, Long roleId) {
        Assert.notNull(userId);Assert.notNull(roleId);
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return deleteSelective(userRole);
    }
}