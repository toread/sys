package com.toread.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.toread.sys.common.tree.SimpleTree;
import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.common.tree.TreeUtils;
import com.toread.sys.config.CacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.toread.sys.mapper.DepartmentMapper;
import com.toread.sys.entity.Department;
import com.toread.sys.service.IDepartmentService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * Department 表数据服务层接口实现类
 */
@Service
public class DepartmentServiceImpl extends SuperServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public boolean addDepartment(Department department) {
        Assert.notNull(findFather(department.getDptPid()),String.format("未找到%s节点",department.getDptId()));
        return insert(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        Assert.notNull(findFather(department.getDptPid()),String.format("未找到%s节点",department.getDptId()));
        return false;
    }

    @Override
    public List<Department> findChildes(Long depId) {
        Assert.notNull(depId,"节点ID不能为空");
        Department treeNode = new Department();
        treeNode.setDptId(depId);
        TreeNode<Department> departmentTreeNode = buildDepartmentTree().findTreeNode(treeNode);
        return CollectionUtils.arrayToList(TreeUtils.getTreeChildesData(departmentTreeNode).toArray());
    }

    @Override
    public Department findFather(Long depId) {
        Assert.notNull(depId,"节点ID不能为空");
        Department treeNode = new Department();
        treeNode.setDptId(depId);
        return (Department) buildDepartmentTree().findTreeNode(treeNode).getFather().getData();
    }

    @Override
    public Tree<Department> buildDepartmentTree() {
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        Tree<Department> departmentTree = (Tree<Department>)cache.get(IDepartmentService.TREE_KEY);
        if(departmentTree == null){
            departmentTree = new SimpleTree<Department>();
            departmentTree.buildTree(this.selectList(new EntityWrapper<Department>()),1L);
            cache.put(IDepartmentService.TREE_KEY,departmentTree);
        }
        return departmentTree;
    }

    private void clearTreeDepartmentCache(){
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        cache.evict(IDepartmentService.TREE_KEY);
    }
}