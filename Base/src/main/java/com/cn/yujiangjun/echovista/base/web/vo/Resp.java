package com.cn.yujiangjun.echovista.base.web.vo;

public record Resp<T>(int code, String mes, T data) {
}
