package com.kings.base.api.controller.demo1;

import com.github.pagehelper.Page;
import com.kings.base.business.demo1.Demo1Service;
import com.kings.base.domain.demo1.entity.Demo1;
import com.kings.base.infrastructure.vo.PageParam;
import com.kings.base.infrastructure.vo.RequestVO;
import com.kings.base.infrastructure.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created on 2019/11/18.
 */
@RestController
@RequestMapping(value = "/demo1")
@Api(description = "DEMO1")
public class Demo1Controller {

    @Autowired
    private Demo1Service demo1Service;


    @GetMapping(value = "/{id}")
    public ResponseVO<Demo1> info(@PathVariable(name = "id") Long id) {
        Demo1 demo1 = demo1Service.getDemo1ById(id);
        return ResponseVO.success(demo1);
    }

    @ApiOperation(value = "用户列表")
    @PostMapping(value = "/list")
    public ResponseVO list(@RequestBody @Validated RequestVO<Demo1> requestVO) {
        PageParam pageParam = new PageParam(1, 2);
        Page<Demo1> demo1Page = demo1Service.listDemo1ByPage(pageParam);
        return ResponseVO.success(demo1Page.getResult());
    }
}
