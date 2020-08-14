package com.kings.base.business.demo1.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kings.base.business.demo1.Demo1Service;
import com.kings.base.domain.demo1.entity.Demo1;
import com.kings.base.domain.demo1.mapper.Demo1Mapper;
import com.kings.base.infrastructure.vo.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/11/18.
 */
@Service
public class Demo1ServiceImpl implements Demo1Service {

    @Autowired
    private Demo1Mapper demo1Mapper;


    @Override
    public Demo1 getDemo1ById(Long id) {
        return demo1Mapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveDemo1(Demo1 demo1) {
        demo1Mapper.insert(demo1);
    }

    @Override
    public void updateDemo1ById(Demo1 demo1) {
        demo1Mapper.updateByPrimaryKey(demo1);
    }

    @Override
    public void deleteDemo1ById(Long id) {
        demo1Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<Demo1> listDemo1ByPage(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        return demo1Mapper.listByPage(null);
    }
}
