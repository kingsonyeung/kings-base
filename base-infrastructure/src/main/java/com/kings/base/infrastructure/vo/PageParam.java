package com.kings.base.infrastructure.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2019/11/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {

    private int pageNum;

    private int pageSize;

    private String order;

    public PageParam(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
