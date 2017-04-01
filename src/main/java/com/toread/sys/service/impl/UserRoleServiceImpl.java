package com.toread.sys.service.impl;

import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.validator.Check;
import com.toread.sys.common.validator.Valid;
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
    private Valid valid;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public boolean bindRole(UserRole userRole) {
        valid.valid(userRole);
        Check.notNull(userService.selectById(userRole.getUserId()), "未找该该用户");
        Check.notNull(roleService.selectById(userRole.getRoleId()), "未找该该角色");
        return processResult(insert(userRole));
    }

    @Override
    public boolean unBindRole(UserRole userRole) {
        valid.valid(userRole);
        Check.notNull(userService.selectById(userRole.getUserId()), "未找该该用户");
        Check.notNull(roleService.selectById(userRole.getRoleId()), "未找该该角色");
        return processResult(delete(userRole));
    }
}