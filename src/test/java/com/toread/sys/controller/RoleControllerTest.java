package com.toread.sys.controller;

import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.spring.mvc.RestResult;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Role;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 黎志兵
 */
public class RoleControllerTest extends ControllerTest {

    @Test
    public void addRole() throws Exception {
        Role role = new Role();
        role.setRoleName("传奇世界");
        RestResult restResult = restTemplate.postForObject(APIRout.RoleAPI.ADD,role, RestResult.class);
        Assert.assertTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void deleteRole() throws Exception {
        Role role = new Role();
        role.setRoleId(1L);
        RestResult restResult = restTemplate.postForObject(APIRout.RoleAPI.DELETE,role, RestResult.class);
        Assert.assertTrue((restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS)));
    }

    @Test
    public void updateRole() throws Exception {
        Role role = new Role();
        role.setRoleName("传奇世界");
        role.setRoleId(2L);
        RestResult restResult = restTemplate.postForObject(APIRout.RoleAPI.UPDATE,role, RestResult.class);
        Assert.assertTrue((restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS)));
    }

    @Test
    public void queryRole() throws Exception {
        Map<String,Object> mps = new HashMap<>();
        mps.put("pageNum","1");
        mps.put("pageSize","22");
        mps.put("roleName","传奇世界");
        RestResult  restResult = restTemplate.postForObject(APIRout.RoleAPI.QUERY,mps,RestResult.class);
        Assert.assertTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }
}