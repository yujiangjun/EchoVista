package com.cn.yujiangjun.echovista.common.dto;

import com.cn.yujiangjun.echovista.common.model.CatQuestion;
import com.cn.yujiangjun.echovista.common.model.QuesContent;
import com.cn.yujiangjun.echovista.common.model.SurveyQues;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class SurveyQuesDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 2554503902766437349L;
    private CatQuestion catQuestion;
    private SurveyQues surveyQues;

    private List<QuesContent> quesItems;
}
