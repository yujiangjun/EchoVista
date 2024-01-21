package com.cn.yujiangjun.echovista.user.folders.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MoveFolderReqDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5650331842499349982L;
    private String folderCode;
    private String oriFolderParentCode;
    private String desFolderParentCode;
}
