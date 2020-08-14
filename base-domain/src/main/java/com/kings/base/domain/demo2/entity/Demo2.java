package com.kings.base.domain.demo2.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created on 2019/11/18.
 */
@Data
@Table(name = "t_demo2")
public class Demo2 {

    @Id
    private Long id;

    private String name;
}
