package com.toread.sys.service.impl;

import com.toread.sys.AccessCtlApplicationTests;
import com.toread.sys.common.enums.State;
import com.toread.sys.entity.*;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleService;
import com.toread.sys.service.IUserRoleService;
import com.toread.sys.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * @author  探路者
 */
public class ResourcesServiceTest extends AccessCtlApplicationTests {
    @Autowired
    private IResourceService resourcesService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private RoleResourceServiceImpl roleResourcesService;
    @Autowired
    private IUserRoleService userRoleService;

    private User user;
    private Resource resources;

    @Before
    public void before(){
        //创建一个用户
        user = new User();
        user.setUserState(State.ENABLED.code());
        user.setUserCode("toread");
        user.setUserPwd("toread");
        userService.insert(user);
        //创建一个角色
        Role role = new Role();
        role.setRoleState(State.ENABLED.code());
        role.setRoleName("官员员");
        roleService.insert(role);
        //创建角色与人员的绑定关系
        UserRole userRole = new UserRole();
        userRole.setRoleId(role.getRoleId());
        userRole.setUserId(user.getUserId());
        userRoleService.insert(userRole);
        //创建一个资源
        resources = new Resource();
        resources.setResName("code");
        resources.setResState(State.ENABLED.code());
        resources.setResType("1");
        resources.setResVal("xxxxx");
        resourcesService.insert(resources);
        //创建资源与角色的绑定关系
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resources.getResId());
        roleResources.setRoleId(role.getRoleId());
        roleResourcesService.insert(roleResources);
    }

    @Test
    public void queryUserResources() throws Exception {
    }

    @Test
    public void allowAccessResources() throws Exception {
        Resource fromDB = resourcesService.selectById(resourcesService.selectById(resources.getResId()));
        Boolean isAllow = resourcesService.allowAccessResources(user.getUserId(),fromDB);
        assertTrue(isAllow);
    }

    @Test
    public void queryRoleResources() throws Exception {

    }

}