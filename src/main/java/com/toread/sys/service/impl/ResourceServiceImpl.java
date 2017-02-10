package com.toread.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.validator.Check;
import com.toread.sys.common.validator.Valid;
import com.toread.sys.entity.Resource;
import com.toread.sys.entity.Role;
import com.toread.sys.mapper.ResourceMapper;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    protected Valid valid;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourcesService;

    @Override
    public Set<Resource> queryUserResources(Long userId, State state) {
        Check.notNull(userId,"用户Id不能为空");Check.notNull(state,"用户状态不能为空");
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
        Check.notNull(userId,"用户Id不能为空");
        Check.notNull(resources,"资源不能为空");
        return queryUserResources(userId,State.ENABLED).contains(resources);
    }

    @Override
    public List<Resource> queryRoleResources(Long roleId, State state) {
        Check.notNull(roleId,"角色Id不能为空");
        Check.notNull(state,"用户状态不能为空");
        return mapper.queryRoleResources(roleId,state.code());
    }

    @Override
    public Integer addResource(Resource resource) {
        valid.valid(resource);
        Check.notNull(State.getState(resource.getResState()), "状态不正确");
        return insert(resource);
    }

    @Override
    public Integer deleteResource(Resource resource) {
        valid.valid(resource, Resource.IDNotNull.class);
        return deleteById(resource.getResId());
    }

    @Override
    public Integer updateResource(Resource resource) {
        valid.valid(resource, Resource.IDNotNull.class);
        valid.validateNotNullProperty(resource);
        return updateSelectiveById(resource);
    }

    @Override
    public Page<Resource> queryResources(PageInfo<Resource> page, Resource user) {
        return null;
    }
}