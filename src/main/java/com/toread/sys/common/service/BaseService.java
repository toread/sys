package com.toread.sys.common.service;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author 黎志兵
 */
public interface BaseService<T,ID> {
    boolean insert(T t);
    boolean insertSelective(T t);
    boolean updateById(T t);
    boolean updateSelectiveById(T t);
    boolean updateByExample(T t,Object example);
    boolean updateByExampleSelective(T t,Object example);
    boolean delete(T t);
    boolean deleteById(ID id);
    boolean deleteByExample(Object example);
    List<T> selectAll();
    List<T> select(T record);
    T selectOne(T record);
    int selectCount(T record);
    T selectById(Object key);
    List<T> selectByExample(Object example);
    int selectCountByExample(Object example);
    Page<T> selectByExamplePage(Object example,Page page);
}
