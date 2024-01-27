package com.cn.yujiangjun.echovista.design.survey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.yujiangjun.echovista.design.survey.model.SurveyQues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SurveyQuesMapper extends BaseMapper<SurveyQues> {
    Page<SurveyQues> getCurrentSurveyALlQues(@Param("page") IPage<SurveyQues> page, @Param("surveyQues") SurveyQues surveyQues);
}