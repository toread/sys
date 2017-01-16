package com.toread.sys.service;

import com.toread.sys.entity.RoleResource;
import org.springframework.util.Assert;

/**
 * @author 黎志兵
 */
public interface IRoleResourceService {
    /**
     * 绑定资源
     * @param roleId
     * @param resourcesId
     * @return
     */
    public boolean bindResources(Long roleId, Long resourcesId);

    /**
     * 解绑资源
     * @param roleId
     * @param resourcesId
     * @return
     */
    public boolean unbindResources(Long roleId, Long resourcesId);
}
