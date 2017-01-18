package com.toread.sys.controller;

import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.spring.mvc.RestResult;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.User;
import com.toread.sys.service.IUserService;
import com.toread.sys.utils.MapBeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黎志兵
 */
public class UserControllerTest  extends ControllerTest{

    @Autowired
    private IUserService userService;
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserState(State.ENABLED.code());
        user.setUserCode("toread11");
        user.setUserPwd("admin");
        Map mpa = MapBeanUtils.beanToMap(user);
        mpa.put("departmentId","2");
        RestResult xxx = restTemplate.postForObject(APIRout.UserAPI.ADD,mpa, RestResult.class);
        Assert.isTrue(xxx.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        user.setUserState(State.ENABLED.code());
        user.setUserCode("toread11");
        user.setUserPwd("admin");
        Map mpa = MapBeanUtils.beanToMap(user);
        mpa.put("departmentId","2");
        RestResult xxx = restTemplate.postForObject(APIRout.UserAPI.ADD,mpa, RestResult.class);
        Assert.isTrue(xxx.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
        RestResult xxx1= restTemplate.postForObject(APIRout.UserAPI.DELETE,mpa, RestResult.class);
        Assert.isTrue(xxx1.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void updateUser() throws Exception {
        List<User> list  = userService.selectAll();
        list.get(0).setUserCode("chuanqi");
        RestResult  restResult = restTemplate.postForObject(APIRout.UserAPI.UPDATE,list.get(0),RestResult.class);
        Assert.isTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void queryUser() throws Exception {
        Map<String,Object> mps = new HashMap<>();
        mps.put("pageNum","1");
        mps.put("pageSize","22");
        mps.put("userCode","");
        RestResult  restResult = restTemplate.postForObject(APIRout.UserAPI.QUERY,mps,RestResult.class);
        Assert.isTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }
}