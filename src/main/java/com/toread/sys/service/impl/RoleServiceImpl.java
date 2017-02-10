package com.toread.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.SimpleBaseService;
import com.toread.sys.common.validator.Check;
import com.toread.sys.common.validator.Valid;
import com.toread.sys.entity.Role;
import com.toread.sys.mapper.RoleMapper;
import com.toread.sys.service.IRoleService;
import com.toread.sys.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    private Valid valid;
    @Override
    public Page<Role> queryRole(Role role, PageInfo pageInfo) {
        Example example = new Example(Role.class);
        Example.Criteria criteria  = example.createCriteria();
        if(State.getState(role.getRoleState())!=null){
            Check.notNull(State.getState(role.getRoleState()),"查询状态不正确");
            criteria.andEqualTo("roleState",role.getRoleState().intValue());
        }else if(StringUtils.hasText(role.getRoleName())){
            criteria.andLike("roleName", FormatUtils.sqlAllLike(role.getRoleName()));
        }
        example.orderBy("c_time");
        return selectByExamplePage(example,pageInfo);
    }

    @Override
    public void addRole(Role role) {
        valid.valid(role);
        role.setRoleState(State.ENABLED.code());
        insert(role);
    }


    @Override
    public void deleteRole(Role role) {
        Check.notNull(role.getRoleId(),"角色Id不能为空");
        deleteById(role.getRoleId());
    }

    @Override
    public Integer updateRole(Role role) {
        Check.notNull(role.getRoleId(),"角色Id不能为空");
        if(State.getState(role.getRoleState())!=null){
            Check.notNull(State.getState(role.getRoleState()),"查询状态不正确");
        }
        return updateSelectiveById(role);
    }


    @Override
    public List<Role> queryUserRole(Long userId, State state) {
        Check.notNull(userId,"用户ID不能为空");
        Check.notNull(state,"角色状态不能为空");
        return mapper.queryUserRole(userId,state.code());
    }
}