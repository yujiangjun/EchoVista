package com.cn.yujiangjun.echovista.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 问卷问题表
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class SurveyQues extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -543603251608710841L;
    private Integer id;

    /**
    * 问题id
    */
    private String quesId;

    /**
    * 问题编码
    */
    private String quesCode;

    /**
    * 问题标题
    */
    private String quesTitle;

    /**
    * 问卷id
    */
    private String surveyId;

    /**
    * 问题序号
    */
    private Integer quesOrder;

    private String externalData;

    private Integer isDeleted;

    /**
    * 是否必填/选 0否1是
    */
    private Short isMustOper;

}