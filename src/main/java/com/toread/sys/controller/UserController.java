package com.toread.sys.controller;

import com.alibaba.fastjson.JSON;
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
}
