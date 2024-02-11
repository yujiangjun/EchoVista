package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AnswerSheetQuesStatRespVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 4567610234568473279L;
    private String surveyId;
    private String quesId;
    /**
     * 问题标题
     */
    private String quesTitle;
    /**
     * 问题序号
     */
    private String quesOrder;
    /**
     * 问题编码，表示问题类型
     */
    private String quesCode;
    /**
     * 问题编码名称
     */
    private String quesCodeName;

    /**
     * 问答数量
     */
    private Integer answerCount;
}
