package com.toread.sys.common.tree;

import com.toread.sys.entity.Department;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author toread
 */
public class SimpleTreeTest {

    private Collection<Department> departments;

    private SimpleTree<Department> departmentTree;

    @Before
    public void init(){
        departments = new ArrayList<Department>();
        Department department = new Department();
        department.setDptId(1L);
        department.setDptPid(0L);
        department.setDptName("市委");

        Department child1 = new Department();
        child1.setDptId(2L);
        child1.setDptPid(1L);
        child1.setDptName("办公室");

        Department child11 = new Department();
        child11.setDptId(3l);
        child11.setDptPid(1L);
        child11.setDptName("秘书组");

        Department child22 = new Department();
        child22.setDptId(4L);
        child22.setDptPid(2L);
        child22.setDptName("监理秘书");

        departments.add(department);
        departments.add(child1);
        departments.add(child11);
        departments.add(child22);
        departmentTree = new SimpleTree<Department>();
        Long sta = System.currentTimeMillis();
        departmentTree.buildTree(departments,1L);
        Long end = System.currentTimeMillis();
        System.out.println(end-sta);
    }

    @Test
    public void getRoot() throws Exception {
        assertNotNull(departmentTree.getRoot());
        assertTrue(departmentTree.getRoot().getData().getDptId().equals(1L));
    }

    @Test
    public void findTreeNode() throws Exception {
        Long sta = System.currentTimeMillis();
        TreeNode t1 = departmentTree.getRoot();
        TreeNode t2 = departmentTree.findTreeNode(departmentTree.getRoot().getData());
        assertTrue(t1.equals(t2));
        TreeNode<Department> t3 = departmentTree.getRoot().getChildes().get(0);
        TreeNode t4 = departmentTree.findTreeNode(t3.getData());
        assertTrue(t3.equals(t4));
        Long end = System.currentTimeMillis();
        System.out.println(end-sta);
    }

    @Test
    public void removeTreeNode() throws Exception {
        TreeNode<Department> t3 = departmentTree.getRoot().getChildes().get(0);
        TreeNode<Department> t4 = departmentTree.removeTreeNode(t3.getData());
        TreeNode t2 = departmentTree.findTreeNode(t3.getData());
        assertNull(t2);
    }

    @Test
    public void getCollection() throws Exception {
        assertTrue(departmentTree.getTreeData().size() == 4);
    }

    @Test
    public void getPath(){
        TreeNode<Department> t3 = departmentTree.getRoot().getChildes().get(0).getChildes().get(0);
        System.out.print(t3.treePath());
    }

}