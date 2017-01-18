package com.toread.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.Check;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.entity.Department;
import com.toread.sys.entity.User;
import com.toread.sys.mapper.UserMapper;
import com.toread.sys.service.IDepartmentService;
import com.toread.sys.service.IUserDepartmentService;
import com.toread.sys.service.IUserService;
import com.toread.sys.utils.FormatUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SimpleBaseService<UserMapper, User,Long> implements IUserService {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IUserDepartmentService userDepartmentService;

    @Override
    public boolean updateById(User user) {
        Check.notNull(user.getUserId(),"用户ID不能为空");
        if(StringUtils.hasText(user.getUserPwd())){
            String pwdSHA256 = DigestUtils.sha256Hex(user.getUserPwd());
            user.setUserPwd(pwdSHA256);
        }else if(user.getUserState()!=null){
            State state = State.getState(user.getUserState());
            Check.notNull(state,"用户状态选择有误");
        }else  if(StringUtils.hasText(user.getUserCode())){
            //判断用户状态
            User fromDB = queryByUserCode(user);
            Check.notNull(fromDB,"该用户账号已被注册");
        }
        return super.updateSelectiveById(user);
    }

    @Override
    @Transactional
    public void addUser(User user, Long departmentId) {
        TreeNode<Department> tTreeNode =  departmentService.buildTree().findTreeNode(new Department(departmentId));
        Check.notNull(tTreeNode,"绑定的机构不存在");
        Check.isNull(queryByUserCode(user), FormatUtils.format("用户{0}已存在",user.getUserCode()));
        String pwdSHA256 = DigestUtils.sha256Hex(user.getUserPwd());
        user.setUserPwd(pwdSHA256);
        insert(user);
        userDepartmentService.bindDepartment(user.getUserId(), Arrays.asList(departmentId));
    }

    private User queryByUserCode(User user){
        Check.notNull(user.getUserCode(),"用户代码不存在");
        User query = new User();
        query.setUserCode(user.getUserCode());
        return selectOne(query);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        Check.notNull(user,"用户不能为空");
        Long userId = user.getUserId();
        Check.notNull(userId,"用户主键不能为空");
        deleteById(userId);
    }

    @Override
    public boolean userLogin(User user) {
        Check.notNull(user,"用戶不能为空");
        Check.notNull(user.getUserCode(),"手机号码不能为空");
        Check.notNull(user.getUserPwd(),"手机号码不能为空");
        String pwdSHA256 = DigestUtils.sha256Hex(user.getUserPwd());
        User query = new User();
        user.setUserCode(user.getUserCode());
        User fromDB = selectOne(query);
        Check.notNull(fromDB,"用户未注册");
        Check.isTrue(pwdSHA256.equals(fromDB.getUserPwd()),"密码错误");
        return true;
    }

    @Override
    public Page<User> queryUsers(PageInfo<User> page, User user) {
        Example example = new Example(User.class);
        example.createCriteria().andLike("userCode","%"+user.getUserCode()+"%");
        return selectByExamplePage(example,page);
    }
}