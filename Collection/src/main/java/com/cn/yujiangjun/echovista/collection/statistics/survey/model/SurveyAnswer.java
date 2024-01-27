package com.cn.yujiangjun.echovista.collection.statistics.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 回答基础表
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class SurveyAnswer extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -3170993073067928398L;

    private Integer id;

    private String ip;

    /**
    * 归属地
    */
    private String location;

    /**
    * 回答时间
    */
    private Date answerDate;

    /**
    * 问卷id
    */
    private String surveyId;

    private Integer isDeleted;

}