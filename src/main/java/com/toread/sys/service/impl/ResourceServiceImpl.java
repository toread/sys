package com.toread.sys.service.impl;

import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.entity.Resource;
import com.toread.sys.entity.Role;
import com.toread.sys.mapper.ResourceMapper;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Resource 表数据服务层接口实现类
 *
 */
@Service
public class ResourceServiceImpl extends SimpleBaseService<ResourceMapper, Resource,Long> implements IResourceService {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourcesService;


    @Override
    public Set<Resource> queryUserResources(Long userId, State state) {
        Assert.notNull(userId);Assert.notNull(state);
        List<Role> roles = roleService.queryUserRole(userId,State.ENABLED);
        if(CollectionUtils.isEmpty(roles))return Collections.emptySet();
        Set<Resource> resources = new HashSet<>(80);
        for (Role role : roles) {
            resources.addAll(resourcesService.queryRoleResources(role.getRoleId(),state));
        }
        return resources;
    }

    @Override
    public boolean  allowAccessResources(Long userId, Resource resources) {
        Assert.notNull(userId);
        Assert.notNull(resources);
        return queryUserResources(userId,State.ENABLED).contains(resources);
    }

    @Override
    public List<Resource> queryRoleResources(Long roleId, State state) {
        Assert.notNull(roleId);
        Assert.notNull(state);
        return mapper.queryRoleResources(roleId,state.code());
    }
}