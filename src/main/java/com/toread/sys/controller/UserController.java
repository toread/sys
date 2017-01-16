package com.toread.sys.controller;

import com.github.pagehelper.Page;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.User;
import com.toread.sys.service.IUserService;
import com.toread.sys.utils.JsonConvertBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
        User user = JsonConvertBeanUtils.mapToBean(User.class,value);
        Assert.notNull(value.get("departmentId"));
        userService.addUser(user,JsonConvertBeanUtils.mapToBean(Long.class,value.get("departmentId")));
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
    public Page<User> queryUser(@RequestBody Map<String,Object> maps){
        Page page = JsonConvertBeanUtils.mapToBean(Page.class,maps);
        User user = JsonConvertBeanUtils.mapToBean(User.class,maps);
        return userService.queryUsers(page,user);
    }
}