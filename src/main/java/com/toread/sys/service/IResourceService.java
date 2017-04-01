package com.toread.sys.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.service.BaseService;
import com.toread.sys.entity.Resource;

import java.util.List;
import java.util.Set;

/**
 * Resource 表数据服务层接口
 */
public interface IResourceService extends BaseService<Resource, Long> {

    /**
     * 获取用户所有资源
     * @param userId 用户ID
     * @return
     */
    Set<Resource> queryUserEnableResources(Long userId);

    /**
     * 判断用户是否可以访问资源
     *
     * @param userId
     * @param resources
     * @return
     */
    boolean allowAccessResources(Long userId, Resource resources);

    /**
     * 查询角色资源
     *
     * @param RoleId
     * @param state
     * @return
     */
    List<Resource> queryRoleResources(Long RoleId, State state);

    /**
     * 增加用户
     *
     * @param user
     */
    Integer addResource(Resource user);

    /**
     * 删除用户
     *
     * @param user
     */
    Integer deleteResource(Resource user);


    /**
     * 删除用户
     *
     * @param user
     */
    Integer updateResource(Resource user);

    /**
     * 查询用户信息
     *
     * @param user
     * @return
     */
    Page<Resource> queryResources(PageInfo<Resource> page, Resource user);
}