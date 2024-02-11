package com.cn.yujiangjun.echovista.app.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SurveyReqVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -1473650767377334344L;
    private String surveyId;
}
