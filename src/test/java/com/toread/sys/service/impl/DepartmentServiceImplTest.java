package com.toread.sys.service.impl;

import com.toread.sys.AccessCtlApplicationTests;
import com.toread.sys.common.tree.Tree;
import com.toread.sys.entity.Department;
import com.toread.sys.service.IDepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author toread
 */
public class DepartmentServiceImplTest  extends AccessCtlApplicationTests {
    private Department child1;
    private Department child11;
    private Department child22;

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void buildDepartmentTree() throws Exception {
        Tree<Department> departmentTree =  departmentService.buildTree();
        assertNotNull(departmentTree);
    }

    @Before
    public void initData(){
        //删除所有数据
        Example example = new Example(Department.class);
        departmentService.deleteByExample(example);
        Department department = new Department();
        department.setDptPid(0L);
        department.setDptId(1L);
        department.setDptType("1");
        department.setDptName("市委");

        departmentService.insert(department);
        child1 = new Department();
        child1.setDptPid(department.getDptId());
        child1.setDptType("1");
        child1.setDptName("办公室");
        departmentService.insert(child1);

        child11 = new Department();
        child11.setDptType("2");
        child11.setDptPid(child1.getDptId());
        child11.setDptName("秘书组");
        departmentService.insert(child11);

        child22 = new Department();
        child22.setDptPid(child11.getDptId());
        child22.setDptType("2");
        child22.setDptName("监理秘书");
        departmentService.insert(child22);
    }

    @Test
    public void findChildes() throws Exception {
        List<Department> department = departmentService.findChildes(1L);
        assertTrue(!CollectionUtils.isEmpty(department));
    }

    @Test
    public void findFather() throws Exception {
        Department department = departmentService.findFather(2L);
        assertNotNull(department);
    }

}