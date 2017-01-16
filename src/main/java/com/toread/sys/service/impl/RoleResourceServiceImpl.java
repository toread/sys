package com.toread.sys.service.impl;

import com.toread.sys.common.service.BaseService;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.entity.RoleResource;
import com.toread.sys.mapper.RoleResourceMapper;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleResourceService;
import com.toread.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * RoleResource 表数据服务层接口实现类
 *
 */
@Service
public class RoleResourceServiceImpl extends SimpleBaseService<RoleResourceMapper, RoleResource,Long> implements IRoleResourceService {
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
    public boolean unbindResources(Long roleId, Long resourcesId) {
        Assert.notNull(roleId);Assert.notNull(roleId);
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resourcesId);
        roleResources.setRoleId(roleId);
        return delete(roleResources);
    }
}