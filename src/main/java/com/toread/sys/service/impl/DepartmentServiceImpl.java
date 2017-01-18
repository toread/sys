package com.toread.sys.service.impl;

import com.toread.sys.common.Check;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.tree.service.SimpleTreeServiceImpl;
import com.toread.sys.config.CacheConfig;
import com.toread.sys.entity.Department;
import com.toread.sys.mapper.DepartmentMapper;
import com.toread.sys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

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
    public boolean addTreeNode(Department department) {
        return super.addTreeNode(department);
    }

    @Override
    public boolean updateTreeNode(Department department) {
        //判断数据
        if(department.getDptState()!=null){
            Check.notNull(State.getState(department.getDptState()),"部门状态不正确");
        }
        //TODO 增加机构类型判断
        return super.updateTreeNode(department);
    }


    @Override
    public Object rootId() {
        return 1L;
    }
}