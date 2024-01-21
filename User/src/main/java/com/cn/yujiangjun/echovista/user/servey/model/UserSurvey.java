package com.cn.yujiangjun.echovista.user.servey.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户调查表
 */
@Data
public class UserSurvey implements Serializable {
    @Serial
    private static final long serialVersionUID = -6087177636841960012L;
    private Integer id;

    private String userSurveyId;

    /**
    * 问卷标题
    */
    private String surveyTitle;

    /**
    * 副标题
    */
    private String surveyDesc;

    /**
    * 所属用户
    */
    private String userId;

    /**
    * 所属目录
    */
    private String folderId;

    private Integer isDeleted;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    /**
    * 问卷状态 0 初始化 1 草稿 2 已发布 3 停止收集
    */
    private Integer status;

}