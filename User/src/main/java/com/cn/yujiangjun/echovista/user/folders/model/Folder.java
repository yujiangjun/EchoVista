package com.cn.yujiangjun.echovista.user.folders.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 个人目录
 */
@Data
public class Folder implements Serializable {

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

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private Integer isDeleted;

    private String externalData;

    @Serial
    private static final long serialVersionUID = 1L;
}