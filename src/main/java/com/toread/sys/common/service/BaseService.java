package com.toread.sys.common.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 黎志兵
 */
public interface BaseService<T,ID> {
    Integer insert(T t);
    Integer insertSelective(T t);
    Integer updateById(T t);
    Integer updateSelectiveById(T t);
    Integer updateByExample(T t,Object example);
    Integer updateByExampleSelective(T t,Object example);
    Integer delete(T t);
    Integer deleteById(ID id);
    Integer deleteByExample(Object example);
    List<T> selectAll();
    List<T> select(T record);
    T selectOne(T record);
    int selectCount(T record);
    T selectById(Object key);
    List<T> selectByExample(Object example);
    int selectCountByExample(Object example);
    Page<T> selectByExamplePage(Object example,PageInfo page);
}
