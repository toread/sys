package com.toread.sys.service.impl;

import org.springframework.stereotype.Service;

import com.toread.sys.mapper.DepartmentMapper;
import com.toread.sys.entity.Department;
import com.toread.sys.service.IDepartmentService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Department 表数据服务层接口实现类
 *
 */
@Service
public class DepartmentServiceImpl extends SuperServiceImpl<DepartmentMapper, Department> implements IDepartmentService {


}