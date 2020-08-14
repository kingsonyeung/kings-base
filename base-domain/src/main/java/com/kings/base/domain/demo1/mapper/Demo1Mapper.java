package com.kings.base.domain.demo1.mapper;

import com.github.pagehelper.Page;
import com.kings.base.domain.demo1.entity.Demo1;
import com.kings.base.infrastructure.mapper.BasicMapper;

import java.util.Map;

/**
 * Created on 2019/11/18.
 */
public interface Demo1Mapper extends BasicMapper<Demo1> {

    Page<Demo1> listByPage(Map<String, Object> paramMap);
}
