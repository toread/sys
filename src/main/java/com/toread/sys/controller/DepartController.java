package com.toread.sys.controller;

import com.alibaba.fastjson.JSON;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Department;
import com.toread.sys.entity.Department;
import com.toread.sys.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author toread
 */
@RestController
public class DepartController {
    private static final Logger log = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 增加一个列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = APIRout.DeptAPI.ADD)
    public Boolean addDepartment(@RequestBody Department Department){
        return departmentService.addTreeNode(Department);
    }

    /**
     * 删除列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.DELETE},value = APIRout.DeptAPI.DELETE)
    public Boolean deleteDepartment(@RequestBody Department Department){
        return  departmentService.deleteTreeNode(Department);
    }

    /**
     * 更新列表
     * @param Department
     * @return
     */
    @RequestMapping(method = {RequestMethod.PUT},value = APIRout.DeptAPI.UPDATE)
    public Boolean updateDepartment(@RequestBody Department Department){
        return departmentService.updateTreeNode(Department);
    }

    /**
     * 获取子节点
     * @param departmentPid
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST},value = APIRout.DeptAPI.CHILDES)
    public List<Department> getChildes(@RequestBody Long departmentPid){
        return departmentService.findChildes(departmentPid);
    }
}
