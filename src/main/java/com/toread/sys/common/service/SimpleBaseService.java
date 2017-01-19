package com.toread.sys.common.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.toread.sys.common.mybatis.CRUDMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 黎志兵
 */
public class SimpleBaseService<M extends CRUDMapper<T>,T,ID> implements  BaseService<T,ID> {
    @Autowired
    protected M mapper;
    @Override
    public Integer insert(T t) {
       return mapper.insert(t);
    }

    @Override
    public Integer insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public Integer updateById(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public Integer updateSelectiveById(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer updateByExample(T t, Object example) {
        return mapper.updateByExample(t,example);
    }

    @Override
    public Integer updateByExampleSelective(T t, Object example) {
        return mapper.updateByExampleSelective(t,example);
    }

    @Override
    public Integer delete(T t) {
        return mapper.delete(t);
    }

    @Override
    public Integer deleteById(ID id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public List<T> selectAll() {
       return mapper.selectAll();
    }

    @Override
    public List<T> select(T record) {
        return mapper.select(record);
    }

    @Override
    public T selectOne(T record) {
        return mapper.selectOne(record);
    }

    @Override
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    @Override
    public T selectById(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    @Override
    public Page<T> selectByExamplePage(Object example, PageInfo page) {
        PageHelper.startPage(page);
        return (Page<T>) mapper.selectByExample(example);
    }

    protected  boolean processResult(int record){
        return record>0;
    }
}
