package com.toread.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.spring.mvc.RestResultMsg;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Role;
import com.toread.sys.entity.UserRole;
import com.toread.sys.service.IRoleService;
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
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleService iUserRoleService;

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.RoleAPI.ADD)
    public void addRole(@RequestBody Map<String, Object> value) {
        Role role = MapBeanUtils.mapToBean(value, Role.class);
        roleService.addRole(role);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.RoleAPI.DELETE)
    public void deleteRole(@RequestBody Role RoleId) {
        roleService.deleteRole(RoleId);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.RoleAPI.UPDATE)
    public void updateRole(@RequestBody Role RoleId) {
        roleService.updateRole(RoleId);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.RoleAPI.QUERY)
    @RestResultMsg
    public PageInfo<Role> queryRole(@RequestBody Map<String, Object> maps) {
        Role role = MapBeanUtils.mapToBean(maps, Role.class);
        PageInfo page = MapBeanUtils.mapToBean(maps, PageInfo.class);
        Page<Role> RolePage = roleService.queryRole(role, page);
        return new PageInfo<Role>(RolePage);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.RoleAPI.BIND_USER_ROLE)
    public void bindUserRole(@RequestBody UserRole userRole) {
        iUserRoleService.bindRole(userRole);
    }

    public void unBindUserRole(@RequestBody UserRole userRole) {
        iUserRoleService.unBindRole(userRole);
    }
}