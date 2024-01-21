package com.cn.yujiangjun.echovista.user.servey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户调查表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserSurvey extends BaseModel implements Serializable {
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

    /**
    * 问卷状态 0 初始化 1 草稿 2 已发布 3 停止收集
    */
    private Integer status;

}