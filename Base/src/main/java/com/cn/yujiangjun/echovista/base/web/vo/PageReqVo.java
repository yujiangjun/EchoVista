package com.cn.yujiangjun.echovista.base.web.vo;

import lombok.Data;

@Data
public class PageReqVo<T> {

    private int page = 1;
    private int pageSize = 10;
    private T payload;
}
