package com.toread.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.Check;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.entity.Role;
import com.toread.sys.mapper.RoleMapper;
import com.toread.sys.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 *
 * Role 表数据服务层接口实现类
 *
 */
@Service
public class RoleServiceImpl extends SimpleBaseService<RoleMapper, Role,Long> implements IRoleService {

    @Override
    public List<Role> queryRoleRole(Role role, PageInfo pageInfo) {
        Example example = new Example(Role.class);
        Example.Criteria criteria  = example.createCriteria();
        if(State.getState(role.getRoleState())!=null){
            Check.notNull(State.getState(role.getRoleState()),"查询状态不正确");
            criteria.andEqualTo("roleState",role.getRoleState().intValue());
        }else if(StringUtils.hasText(role.getRoleName())){
            criteria.andLike("roleState","%"+role.getRoleName()+"%");
        }
        example.orderBy("c_time");
        return selectByExamplePage(example,pageInfo);
    }

    @Override
    public void addRole(Role role, Long departmentId) {

    }

    @Override
    public void deleteRole(Role role) {

    }
}