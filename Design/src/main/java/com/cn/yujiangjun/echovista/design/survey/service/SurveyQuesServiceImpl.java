package com.cn.yujiangjun.echovista.design.survey.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.common.mapper.SurveyQuesMapper;
import com.cn.yujiangjun.echovista.common.model.SurveyQues;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SurveyQuesServiceImpl extends ServiceImpl<SurveyQuesMapper, SurveyQues> {

    private final SurveyQuesMapper surveyQuesMapper;

    public Page<SurveyQues> getCurrentSurveyALlQues(SurveyQues surveyQues, int page, int pageSize) {
        if (CharSequenceUtil.isBlank(surveyQues.getSurveyId())) {
            throw new SurveyException(CommonError.PARAMS_NOT_EXISTS);
        }
        return surveyQuesMapper.getCurrentSurveyALlQues(new Page<SurveyQues>(page, pageSize), surveyQues);
    }
}
