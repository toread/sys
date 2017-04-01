package com.toread.sys.mapper;

import com.toread.sys.common.mybatis.CRUDMapper;
import com.toread.sys.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 *
 * Resource 表数据库控制层接口
 *
 */
public interface ResourceMapper extends CRUDMapper<Resource> {

    /**
     * 查询资源
     * @param roleId 资源ID
     * @param state 状态
     * @return
     */
    List<Resource> queryRoleResources(@Param("roleId")Long roleId, @Param("state")Integer state);

    /**
     * 查询用户有效的资源
     *
     * @param roleId
     * @return
     */
    Set<Resource> queryUserEnableResources(@Param("userId") Long roleId);
}