package com.cn.yujiangjun.echovista.collection.statistics.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 答卷统计详情表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyAnswerStat extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -2712518603878033270L;
    private Integer id;

    /**
    * 问卷id
    */
    private String surveyId;

    /**
    * 问题id
    */
    private String quesId;

    /**
    * 回答人数
    */
    private Integer answerCount;

    private Integer isDeleted;

}