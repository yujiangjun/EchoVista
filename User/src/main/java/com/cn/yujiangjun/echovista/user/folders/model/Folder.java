package com.cn.yujiangjun.echovista.user.folders.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 个人目录
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Folder extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -8697744205555046289L;
    private Integer id;

    /**
    * 目录code
    */
    private Integer folderCode;

    /**
    * 目录名称
    */
    private String folderName;

    /**
    * 父目录code
    */
    private Integer folderPartentCode;

    /**
    * 父目录名称
    */
    private String folderParentName;

    /**
    * 目录icon
    */
    private String icon;

    /**
    * 拥有者id
    */
    private String ownerId;


    private Integer isDeleted;

    private String externalData;
}