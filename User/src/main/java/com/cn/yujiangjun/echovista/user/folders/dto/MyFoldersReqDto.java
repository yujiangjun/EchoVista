package com.cn.yujiangjun.echovista.user.folders.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MyFoldersReqDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -8179365078131156648L;
    /**
     * 用有人id
     */
    private String ownerId;
}
