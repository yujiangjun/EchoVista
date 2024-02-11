package com.cn.yujiangjun.echovista.collection.statistics.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 答卷问题选项统计表
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyAnswerItemStat extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -5198704397163456621L;
    private Integer id;

    /**
    * 答卷问题统计id
    */
    private Integer answerStatId;

    /**
    * 问题选项id
    */
    private Integer surveyAnswerItemId;

    /**
    * 该选项被选择数量
    */
    private Integer itemCount;

    private Integer isDeleted;

}