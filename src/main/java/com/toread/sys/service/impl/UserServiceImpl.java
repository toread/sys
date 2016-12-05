package com.toread.sys.service.impl;

import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.entity.Department;
import com.toread.sys.entity.UserDepartment;
import com.toread.sys.service.IDepartmentService;
import com.toread.sys.service.IUserDepartmentService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toread.sys.mapper.UserMapper;
import com.toread.sys.entity.User;
import com.toread.sys.service.IUserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IUserDepartmentService userDepartmentService;

    @Override
    @Transactional
    public void addUser(User user, Long departmentId) {
        TreeNode<Department> tTreeNode =  departmentService.buildDepartmentTree().findTreeNode(new Department(departmentId));
        Assert.notNull(tTreeNode,"机构不存在");
        Assert.isNull(queryByUserCode(user),String.format("用户s%已存在",user.getUserCode()));
        String pwdSHA256 = DigestUtils.sha256Hex(user.getUserPwd());
        user.setUserPwd(pwdSHA256);
        insert(user);
        userDepartmentService.bindUser(user.getUserId(),departmentId);
    }

    private User queryByUserCode(User user){
        Assert.notNull(user.getUserCode(),"用户代码不存在");
        User query = new User();
        query.setUserCode(user.getUserCode());
        return selectOne(query);
    }

    @Override
    @Transactional
    public void deleteUser(User user, Long departmentId) {
        Long userId = user.getUserId();
        Assert.notNull(userId,"用户主键不能为空");
        deleteById(userId);
        userDepartmentService.unBindUser(userId,departmentId);
    }

    @Override
    public boolean userLogin(User user) {
        Assert.notNull(user,"用戶不能为空");
        Assert.notNull(user.getUserCode(),"手机号码不能为空");
        Assert.notNull(user.getUserPwd(),"手机号码不能为空");
        //加密用户树
        return false;
    }
}