package com.toread.sys.service.impl;

import org.springframework.stereotype.Service;

import com.toread.sys.mapper.UserDepartmentMapper;
import com.toread.sys.entity.UserDepartment;
import com.toread.sys.service.IUserDepartmentService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.util.Assert;

/**
 *
 * UserDepartment 表数据服务层接口实现类
 *
 */
@Service
public class UserDepartmentServiceImpl extends SuperServiceImpl<UserDepartmentMapper, UserDepartment> implements IUserDepartmentService {


    @Override
    public boolean bindUser(Long userId, Long dptId) {
        Assert.notNull(userId);Assert.notNull(dptId);
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setId(userId);
        userDepartment.setDptId(dptId);
        Assert.isNull(selectOne(userDepartment),"已经绑定过此部门下");
        return insert(userDepartment);
    }

    @Override
    public boolean unBindUser(Long userId, Long dptId) {
        Assert.notNull(userId);Assert.notNull(dptId);
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setId(userId);
        userDepartment.setDptId(dptId);
        Assert.notNull(selectOne(userDepartment),"未绑定过该部门");
        return false;
    }
}