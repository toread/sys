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
        Tree<Department> departmentTree =  departmentService.buildDepartmentTree();
        assertNotNull(departmentTree);
    }

    @Before
    public void initData(){
        //删除所有数据
        departmentService.deleteBatchIds(Arrays.asList(1L,2L,3L,4L));
        Department department = new Department();
        department.setDptId(1L);
        department.setDptPid(0L);
        department.setDptType("1");
        department.setDptName("市委");

        child1 = new Department();
        child1.setDptId(2L);
        child1.setDptPid(1L);
        child1.setDptType("1");
        child1.setDptName("办公室");

        child11 = new Department();
        child11.setDptId(3l);
        child11.setDptType("2");
        child11.setDptPid(1L);
        child11.setDptName("秘书组");

        child22 = new Department();
        child22.setDptId(4L);
        child22.setDptPid(2L);
        child22.setDptType("2");
        child22.setDptName("监理秘书");

        departmentService.insert(department);
        departmentService.insert(child1);
        departmentService.insert(child11);
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