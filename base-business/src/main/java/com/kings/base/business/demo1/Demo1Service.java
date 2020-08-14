package com.kings.base.business.demo1;

import com.github.pagehelper.Page;
import com.kings.base.domain.demo1.entity.Demo1;
import com.kings.base.infrastructure.vo.PageParam;

/**
 * Created on 2019/11/18.
 */
public interface Demo1Service {


    Demo1 getDemo1ById(Long id);

    void saveDemo1(Demo1 demo1);

    void updateDemo1ById(Demo1 demo1);

    void deleteDemo1ById(Long id);

    Page<Demo1> listDemo1ByPage(PageParam pageParam);
}
