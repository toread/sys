package com.toread.sys.service.impl;

import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.validate.Check;
import com.toread.sys.entity.RoleResource;
import com.toread.sys.mapper.RoleResourceMapper;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleResourceService;
import com.toread.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Check.notNull(roleId,"角色ID不能为空");
        Check.notNull(resourcesService.selectById(resourcesId),"未找到该资源");
        Check.notNull(roleService.selectById(roleId),"未找到该角色");
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resourcesId);
        roleResources.setRoleId(roleId);
        return processResult(insert(roleResources));
    }

    @Override
    public boolean unbindResources(Long roleId, Long resourcesId) {
        Check.notNull(roleId,"角色ID不能为空");Check.notNull(resourcesId,"资源Id不能为空");
        RoleResource roleResources = new RoleResource();
        roleResources.setResId(resourcesId);
        roleResources.setRoleId(roleId);
        return processResult(delete(roleResources));
    }
}