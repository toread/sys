package com.toread.sys.controller;

import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Department;
import com.toread.sys.entity.UserDepartment;
import com.toread.sys.service.IDepartmentService;
import com.toread.sys.service.IUserDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author toread
 */
@RestController
public class DepartController {
    private static final Logger log = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IUserDepartmentService userDepartmentService;

    /**
     * 增加一个部门
     *
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.DeptAPI.ADD)
    public Boolean addDepartment(@Validated @RequestBody Department Department) {
        return departmentService.addTreeNode(Department);
    }

    /**
     * 删除一个部门
     *
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.DeptAPI.DELETE)
    public void deleteDepartment(@RequestBody Department Department) {
        departmentService.deleteTreeNode(Department);
    }

    /**
     * 更新一个部门
     *
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.PUT}, value = APIRout.DeptAPI.UPDATE)
    public Boolean updateDepartment(@RequestBody Department Department) {
        return departmentService.updateTreeNode(Department);
    }

    /**
     * 获取子节点
     *
     * @param departmentPid
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.DeptAPI.CHILDES)
    public List<Department> getChildes(@RequestBody Long departmentPid) {
        return departmentService.findChildes(departmentPid);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.DeptAPI.BIND_USER_DEPART)
    public void bindUserDepart(UserDepartment userDepartment) {
        userDepartmentService.bindDepartment(userDepartment.getUserId(), Arrays.asList(userDepartment.getDptId()));
    }

    @RequestMapping(method = {RequestMethod.POST}, value = APIRout.DeptAPI.UN_BIND_USER_DEPART)
    public void unBindUserDepart(UserDepartment userDepartment) {
        userDepartmentService.bindDepartment(userDepartment.getUserId(), Arrays.asList(userDepartment.getDptId()));
    }
}
