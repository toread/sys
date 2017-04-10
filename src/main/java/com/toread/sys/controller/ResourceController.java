package com.toread.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.spring.mvc.RestResultMsg;
import com.toread.sys.common.validator.Check;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Resource;
import com.toread.sys.entity.UserRole;
import com.toread.sys.service.IResourceService;
import com.toread.sys.service.IUserRoleService;
import com.toread.sys.utils.MapBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author toread
 */
@RestController
public class ResourceController {
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.ADD)
    public void addResource(@RequestBody Map<String, Object> value) {
        Resource Resource = MapBeanUtils.mapToBean(value, Resource.class);
        Check.isTrue(resourceService.addResource(Resource) > 0, "新增资源失败");
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.DELETE)
    public void deleteResource(@RequestBody Resource resource) {
        Check.isTrue(resourceService.deleteResource(resource) > 0, "删除资源失败");
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.UPDATE)
    public void updateResource(@RequestBody Resource resource) {
        Check.isTrue(resourceService.updateResource(resource) > 0, "更新资源失败");
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.QUERY)
    @RestResultMsg
    public PageInfo<Resource> queryResource(@RequestBody Map<String, Object> maps) {
        Resource resource = MapBeanUtils.mapToBean(maps, Resource.class);
        PageInfo page = MapBeanUtils.mapToBean(maps, PageInfo.class);
        Page<Resource> ResourcePage = resourceService.queryResources(page, resource);
        return new PageInfo<Resource>(ResourcePage);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.BIND_ROLE_RESOURCE)
    public void bindRoleResource(@RequestBody UserRole userRole) {
        userRoleService.bindRole(userRole);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.ResourceAPI.UN_BIND_ROLE_RESOURCE)
    public void unBindRoleResource(@RequestBody UserRole userRole) {
        userRoleService.unBindRole(userRole);
    }
}