package com.toread.sys.service.impl;

import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.validate.Check;
import com.toread.sys.entity.UserDepartment;
import com.toread.sys.mapper.UserDepartmentMapper;
import com.toread.sys.service.IUserDepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * UserDepartment 表数据服务层接口实现类
 *
 */
@Service
public class UserDepartmentServiceImpl extends SimpleBaseService<UserDepartmentMapper, UserDepartment,Long> implements IUserDepartmentService {


    @Override
    public boolean bindDepartment(Long userId, List<Long> dptIds) {
        Check.notEmpty(dptIds,"绑定的机构不能为空");
        Check.notNull(userId,"用户Id不能为空");Check.notEmpty(dptIds,"部门Id集合不能为空");
        List<UserDepartment> departments = new ArrayList<UserDepartment>();
        for (Long dptId : dptIds) {
            UserDepartment userDepartment = new UserDepartment();
            userDepartment.setUserId(userId);
            userDepartment.setDptId(dptId);
            Check.isNull(selectOne(userDepartment),"已经绑定过此部门下");
            departments.add(userDepartment);
        }
        for (UserDepartment department : departments) {
            insert(department);
        }
        return true;
    }

    @Override
    public boolean unBindDepartment(Long userId, List<Long> dptIds) {
        Check.notNull(userId,"用户Id不能为空");Check.notEmpty(dptIds,"部门Id集合不能为空");
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setId(userId);
        Check.notNull(selectOne(userDepartment),"未绑定过该部门");
        return false;
    }
}