package com.toread.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.toread.sys.common.tree.SimpleTree;
import com.toread.sys.common.tree.Tree;
import com.toread.sys.common.tree.TreeNode;
import com.toread.sys.common.tree.TreeUtils;
import com.toread.sys.common.tree.service.SimpleTreeService;
import com.toread.sys.common.tree.service.SimpleTreeServiceImpl;
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
public class DepartmentServiceImpl extends SimpleTreeServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private CacheManager cacheManager;

    private void clearTreeDepartmentCache(){
        Cache cache = cacheManager.getCache(CacheConfig.CTL_TREE_CHCHE);
        cache.evict(keyName());
    }

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }

    @Override
    protected String keyName() {
        return IDepartmentService.TREE_KEY;
    }

    @Override
    public Object rootId() {
        return 1L;
    }
}