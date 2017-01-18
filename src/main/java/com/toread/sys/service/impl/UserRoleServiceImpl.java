package com.toread.sys.service.impl;

import com.toread.sys.common.Check;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.entity.UserRole;
import com.toread.sys.mapper.UserRoleMapper;
import com.toread.sys.service.IRoleService;
import com.toread.sys.service.IUserRoleService;
import com.toread.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * UserRole 表数据服务层接口实现类
 *
 */
@Service
public class UserRoleServiceImpl extends SimpleBaseService<UserRoleMapper, UserRole,Long> implements IUserRoleService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public boolean bindRole(Long userId, Long roleId) {
        Check.notNull(userId,"用户ID不能为空");Check.notNull(roleId,"角色Id不能为空");
        Check.notNull(userService.selectById(userId),"未找该该用户");
        Check.notNull(roleService.selectById(roleId),"未找该该角色");
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return insert(userRole);
    }

    @Override
    public boolean unBindRole(Long userId, Long roleId) {
        Check.notNull(userId,"用户ID不能为空");Check.notNull(roleId,"角色Id不能为空");
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return delete(userRole);
    }
}