package com.cn.yujiangjun.echovista.user.folders.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyFoldersReqDto implements Serializable {


    /**
     * 用有人id
     */
    private String ownerId;
}
