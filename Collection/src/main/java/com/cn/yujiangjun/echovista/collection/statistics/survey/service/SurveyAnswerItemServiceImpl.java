package com.cn.yujiangjun.echovista.collection.statistics.survey.service;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerItemMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswerItem;
import com.cn.yujiangjun.echovista.collection.statistics.survey.remote.SurveyRemoteService;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.SurveyAnswerItemVo;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.constants.SurveyStatusEnum;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SurveyAnswerItemServiceImpl extends ServiceImpl<SurveyAnswerItemMapper, SurveyAnswerItem> {

    private final SurveyRemoteService surveyRemoteService;
    public SurveyAnswerItem addItem(SurveyAnswerItemVo surveyAnswerItemVo) {
        UserSurvey survey = new UserSurvey();
        survey.setId(Integer.parseInt(surveyAnswerItemVo.getSurveyId()));
        UserSurvey userSurvey = surveyRemoteService.getInfoById(survey);
        if (Objects.isNull(userSurvey)){
            throw new SurveyException(CommonError.CURRENT_SURVEY_NOT_EXISTS);
        }
        if (Objects.equals(SurveyStatusEnum.STOP_COLLECTED.getCode(),userSurvey.getStatus())){
            throw new SurveyException(CommonError.CURRENT_SURVEY_STOP_COLLECTED);
        }
        surveyAnswerItemVo.setAnswerItemId(UUID.randomUUID().toString());
        surveyAnswerItemVo.setIsDeleted(DelFlagEnum.NO.getCode());
        save(surveyAnswerItemVo);
        return surveyAnswerItemVo;
    }
}
