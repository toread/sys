package com.toread.sys.service;

import com.toread.sys.entity.RoleResource;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * RoleResource 表数据服务层接口
 *
 */
public interface IRoleResourceService extends ISuperService<RoleResource> {
    /**
     * 角色绑定资源
     * @param roleId
     * @param resourcesId
     * @return
     */
    boolean bindResources(Long roleId,Long resourcesId);

    /**
     * 角色解除资源
     * @param roleId
     * @param resourcesId
     * @return
     */
    boolean unBindRole(Long roleId,Long resourcesId);

}