package com.toread.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.Check;
import com.toread.sys.common.data.ShieldBeanProperty;
import com.toread.sys.common.spring.mvc.RestResultMsg;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Role;
import com.toread.sys.service.IRoleService;
import com.toread.sys.service.IRoleService;
import com.toread.sys.utils.MapBeanUtils;
import org.apache.commons.collections.MapUtils;
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

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.RoleAPI.ADD)
    public void addRole(@RequestBody Map<String,Object> value){
        Role role = MapBeanUtils.mapToBean(value,Role.class);
        Check.notNull(value.get("departmentId"),"departmentId不能为空");
        roleService.addRole();
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.RoleAPI.DELETE)
    public void deleteRole(@RequestBody Role RoleId){
        roleService.deleteRole(RoleId);
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.RoleAPI.UPDATE)
    public void updateRole(@RequestBody Role RoleId){
        roleService.updateById(RoleId);
    }

    @RequestMapping(method = {RequestMethod.POST},value = APIRout.RoleAPI.QUERY)
    @RestResultMsg
    public PageInfo<Role> queryRole(@RequestBody Map<String,Object> maps){
        Role role = MapBeanUtils.mapToBean(maps,Role.class);
        PageInfo page = MapBeanUtils.mapToBean(maps,PageInfo.class);
        Page<Role>  RolePage = ShieldBeanProperty.process(roleService.queryRoles(page,Role),"RolePwd");
        return new PageInfo<Role>(RolePage);
    }
}