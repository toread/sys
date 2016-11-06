package com.toread.sys.common.tree;

import com.toread.sys.entity.Department;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toread on 16-10-26.
 */
public class Simple1TreeNodeTest {
    @Test
    public void buildTree() throws Exception {
        List<Department>  departments = new ArrayList<Department>();
        Department department = new Department();
        department.setDptId(1L);
        department.setDptPid(0L);

        Department child1 = new Department();
        child1.setDptId(2L);
        child1.setDptPid(1L);

        Department child11 = new Department();
        child11.setDptId(3l);
        child11.setDptPid(1L);

        Department child22 = new Department();
        child22.setDptId(4L);
        child22.setDptPid(2L);

        departments.add(department);
        departments.add(child1);
        departments.add(child11);
        departments.add(child22);

        Simple1TreeNode<Department> departmentSimple1TreeNode = Simple1TreeNode.build(departments,1L);
        System.out.println(departmentSimple1TreeNode);
    }
}