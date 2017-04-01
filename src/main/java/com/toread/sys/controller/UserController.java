package com.toread.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.data.ShieldBeanProperty;
import com.toread.sys.common.exception.BusinessException;
import com.toread.sys.common.spring.mvc.RestResultMsg;
import com.toread.sys.common.validator.Check;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.User;
import com.toread.sys.service.IUserService;
import com.toread.sys.utils.MapBeanUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author toread
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.UserAPI.ADD)
    public void addUser(@RequestBody Map<String,Object> value){
        User user = MapBeanUtils.mapToBean(value,User.class);
        Check.notNull(value.get("departmentId"),"departmentId不能为空");
        userService.addUser(user, MapUtils.getLong(value,"departmentId"));
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.UserAPI.DELETE)
    public void deleteUser(@RequestBody User userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.UserAPI.UPDATE)
    public void updateUser(@RequestBody User userId){
        userService.updateById(userId);
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.UserAPI.QUERY)
    @RestResultMsg
    public PageInfo<User> queryUser(@RequestBody Map<String,Object> maps){
        User user = MapBeanUtils.mapToBean(maps,User.class);
        PageInfo page = MapBeanUtils.mapToBean(maps,PageInfo.class);
        Page<User>  userPage = ShieldBeanProperty.process(userService.queryUsers(page,user),"userPwd");
        return new PageInfo<User>(userPage);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.UserAPI.LOGIN)
    public void login(@RequestBody User user) {
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUserCode(), user.getUserPwd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upt);
        } catch (AuthenticationException e) {
            throw new BusinessException(e, "您的账号或密码输入错误!");
        }
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.UserAPI.LOGOUT)
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}