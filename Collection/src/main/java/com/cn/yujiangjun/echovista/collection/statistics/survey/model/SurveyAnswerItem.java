package com.cn.yujiangjun.echovista.collection.statistics.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 问卷回答明细表
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class SurveyAnswerItem extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -7180430006640324283L;

    private Integer id;

    /**
    * 回答表id
    */
    private String answerId;

    /**
    * 问题id
    */
    private String quesId;

    /**
    * 回答明细id
    */
    private String answerItemId;

    /**
    * 回答的值,可能是选项，也可能是输入的，用JSON对象保存
    */
    private String itemValue;

    private Integer isDeleted;

}