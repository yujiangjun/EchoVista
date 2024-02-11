package com.cn.yujiangjun.echovista.app.survey.vo;

import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class SurveyInfoVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -2925738628034050095L;

    private UserSurvey userSurvey;

    private List<SurveyQuesDTO> questions;
}
