package com.kings.base.domain.demo1.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created on 2019/11/18.
 */
@Data
@Table(name = "t_demo1")
public class Demo1 implements Serializable{

    @Id
    private Long id;

    @NotNull(message="name不能为空!")
    private String name;
}
