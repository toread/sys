package com.toread.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.mvc.RestResult;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Department;
import com.toread.sys.entity.User;
import com.toread.sys.utils.JsonConvertBeanUtils;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 黎志兵
 */
public class UserControllerTest  extends ControllerTest{

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserState(State.ENABLED.code());
        user.setUserCode("toread11");
        user.setUserPwd("admin");
        Map mpa = JsonConvertBeanUtils.mapToBean(Map.class,user);
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
        Map mpa = JsonConvertBeanUtils.mapToBean(Map.class,user);
        mpa.put("departmentId","2");
        RestResult xxx = restTemplate.postForObject(APIRout.UserAPI.ADD,mpa, RestResult.class);
        Assert.isTrue(xxx.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
        RestResult xxx1= restTemplate.postForObject(APIRout.UserAPI.DELETE,mpa, RestResult.class);
        Assert.isTrue(xxx1.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void queryUser() throws Exception {

    }
}