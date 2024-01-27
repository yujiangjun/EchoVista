package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswerItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class SurveyAnswerItemVo extends SurveyAnswerItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 8340806404151601152L;
    private String surveyId;
}
