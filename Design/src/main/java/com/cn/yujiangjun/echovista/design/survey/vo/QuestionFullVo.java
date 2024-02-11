package com.cn.yujiangjun.echovista.design.survey.vo;

import com.cn.yujiangjun.echovista.common.model.QuesContent;
import com.cn.yujiangjun.echovista.common.model.SurveyQues;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionFullVo extends SurveyQues implements Serializable {
    @Serial
    private static final long serialVersionUID = -3445401844045538500L;

    /**
     * 问题条目
     */
    private List<QuesContent> quesContentList;
}
