package com.toread.sys.service;

import com.toread.sys.common.enums.State;
import com.toread.sys.entity.Resource;
import com.baomidou.framework.service.ISuperService;

import java.util.List;
import java.util.Set;

/**
 *
 * Resource 表数据服务层接口
 *
 */
public interface IResourceService extends ISuperService<Resource> {
    /**
     * 获取用户所有资源
     * @param userId 用户ID
     * @param state 资源状态
     * @return
     */
    Set<Resource> queryUserResources(Long userId, State state);

    /**
     * 判断用户是否可以访问资源
     * @param userId
     * @param resources
     * @return
     */
    boolean allowAccessResources(Long userId,Resource resources);

    /**
     * 查询角色资源
     * @param RoleId
     * @param state
     * @return
     */
    List<Resource> queryRoleResources(Long RoleId, State state);

}