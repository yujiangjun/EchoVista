package com.cn.yujiangjun.echovista.collection.statistics.survey.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerItemMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswer;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswerItem;
import com.cn.yujiangjun.echovista.collection.statistics.survey.remote.SurveyRemoteService;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.DelAnswerSheetReqVo;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.constants.SurveyStatusEnum;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class SurveyAnswerServiceImpl extends ServiceImpl<SurveyAnswerMapper, SurveyAnswer> {

    private final SurveyAnswerItemMapper surveyAnswerItemMapper;
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

    @Transactional
    public void delAnswerSheet(DelAnswerSheetReqVo reqVo) {
        SurveyAnswer answer = getById(reqVo.getAnswerId());
        if (Objects.isNull(answer) || Objects.equals(answer.getIsDeleted(), DelFlagEnum.YES.getCode())) {
            log.debug("当前答卷已删除,answerId:{}", reqVo);
        }
        answer.setIsDeleted(DelFlagEnum.YES.getCode());
        updateById(answer);
        LambdaQueryWrapper<SurveyAnswerItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SurveyAnswerItem::getAnswerId, reqVo.getAnswerId())
                .eq(SurveyAnswerItem::getIsDeleted, DelFlagEnum.YES.getCode());
        List<SurveyAnswerItem> surveyAnswerItemList = surveyAnswerItemMapper.selectList(wrapper);
        if (CollUtil.isEmpty(surveyAnswerItemList)) {
            log.info("当前答卷中未提交任何回答");
            return;
        }
        surveyAnswerItemList.forEach(t -> {
            t.setIsDeleted(DelFlagEnum.YES.getCode());
            surveyAnswerItemMapper.updateById(t);
        });
    }
}
