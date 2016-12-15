package com.toread.sys.controller;

import com.toread.sys.entity.Department;
import com.toread.sys.entity.Department;
import com.toread.sys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author toread
 */
@RestController
@RequestMapping(path = "/depart")
public class DepartController {
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 增加一个列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "add")
    public Boolean addDepartment(Department Department){
        return departmentService.addTreeNode(Department);
    }

    /**
     * 删除列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "delete")
    public Boolean deleteDepartment(Department Department){
        return  departmentService.deleteTreeNode(Department);
    }

    /**
     * 更新列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = "update")
    public Boolean updateDepartment(Department Department){
        return departmentService.updateTreeNode(Department);
    }

    /**
     * 获取子节点
     * @param DepartmentPid
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},path = "getChildes")
    public List<Department> getChildes(@RequestParam("pid") Long DepartmentPid){
        return departmentService.findChildes(DepartmentPid);
    }
}
