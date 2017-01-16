package com.toread.sys.mapper;

import com.toread.sys.common.mybatis.CRUDMapper;
import com.toread.sys.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * Role 表数据库控制层接口
 *
 */
public interface RoleMapper extends CRUDMapper<Role> {
    /**
     * 根据用户ID及状态查询用户拥有的角色
     * @param userId 用户ID
     * @param state 角色状态
     * @return
     */
    List<Role> queryUserRole(@Param("id") Long userId, @Param("state")Integer state);

}