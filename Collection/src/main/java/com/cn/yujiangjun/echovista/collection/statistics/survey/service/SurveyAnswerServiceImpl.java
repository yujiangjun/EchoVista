package com.cn.yujiangjun.echovista.collection.statistics.survey.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswer;
import com.cn.yujiangjun.echovista.collection.statistics.survey.remote.SurveyRemoteService;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.constants.SurveyStatusEnum;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SurveyAnswerServiceImpl extends ServiceImpl<SurveyAnswerMapper, SurveyAnswer> {


    private final SurveyRemoteService surveyRemoteService;

    public SurveyAnswer addSurveyAnswer(SurveyAnswer surveyAnswer) {
        UserSurvey survey = new UserSurvey();
        survey.setId(Integer.parseInt(surveyAnswer.getSurveyId()));
        UserSurvey userSurvey = surveyRemoteService.getInfoById(survey);
        if (Objects.isNull(userSurvey)) {
            throw new SurveyException(CommonError.CURRENT_SURVEY_NOT_EXISTS);
        }
        if (Objects.equals(SurveyStatusEnum.STOP_COLLECTED.getCode(), userSurvey.getStatus())) {
            throw new SurveyException(CommonError.CURRENT_SURVEY_STOP_COLLECTED);
        }
        save(surveyAnswer);
        return surveyAnswer;
    }
}
