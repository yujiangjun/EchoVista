package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AnswerSheetQuesItemStatRespVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 4567610234568473279L;
    /**
     * 问题选项id
     */
    private String quesContentId;
    /**
     * 问题选项显示
     */
    private String quesContentLabel;
    /**
     * 问题选项值
     */
    private String quesContentValue;
    /**
     * 问题选项序号
     */
    private String quesContentOrder;
    /**
     * 问卷中选择这个选项的数量
     */
    private Integer answerCount;

    /**
     * 问卷中选择这个选项的百分比
     */
    private String answerPercentage;
}
