package com.toread.sys.service.impl;

import com.toread.sys.mapper.RoleResourceMapper;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toread.sys.entity.RoleResource;
import com.toread.sys.service.IRoleResourceService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.util.Assert;

/**
 *
 * RoleResource 表数据服务层接口实现类
 *
 */
@Service
public class RoleResourceServiceImpl extends SuperServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourcesService;


    @Override
    public boolean bindResources(Long roleId, Long resourcesId) {
        Assert.notNull(roleId);Assert.notNull(roleId);
        Assert.notNull(resourcesService.selectById(resourcesId));
        Assert.notNull(roleService.selectById(roleId));
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resourcesId);
        roleResources.setRoleId(roleId);
        return insert(roleResources);
    }

    @Override
    public boolean unBindRole(Long roleId, Long resourcesId) {
        Assert.notNull(roleId);Assert.notNull(roleId);
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resourcesId);
        roleResources.setRoleId(roleId);
        return deleteSelective(roleResources);
    }
}