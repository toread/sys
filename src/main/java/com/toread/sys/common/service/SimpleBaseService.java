package com.toread.sys.common.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public boolean insert(T t) {
       return processResult(mapper.insert(t));
    }

    @Override
    public boolean insertSelective(T t) {
        return processResult(mapper.insertSelective(t));
    }

    @Override
    public boolean updateById(T t) {
        return processResult(mapper.updateByPrimaryKey(t));
    }

    @Override
    public boolean updateSelectiveById(T t) {
        return processResult(mapper.updateByPrimaryKeySelective(t));
    }

    @Override
    public boolean updateByExample(T t, Object example) {
        return processResult(mapper.updateByExample(t,example));
    }

    @Override
    public boolean updateByExampleSelective(T t, Object example) {
        return processResult(mapper.updateByExampleSelective(t,example));
    }

    @Override
    public boolean delete(T t) {
        return processResult(mapper.delete(t));
    }

    @Override
    public boolean deleteById(ID id) {
        return processResult(mapper.deleteByPrimaryKey(id));
    }

    @Override
    public boolean deleteByExample(Object example) {
        return processResult(mapper.deleteByExample(example));
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
    public Page<T> selectByExamplePage(Object example, Page page) {
        PageHelper.startPage(page);
        return (Page<T>) mapper.selectByExample(example);
    }

    protected  boolean processResult(int record){
        return record>0;
    }
}
