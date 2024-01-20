package com.cn.yujiangjun.echovista.user.folders.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MoveFolderReqDto implements Serializable {

    private String folderCode;
    private String oriFolderParentCode;
    private String desFolderParentCode;
}
