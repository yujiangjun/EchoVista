package com.cn.yujiangjun.echovista.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.yujiangjun.echovista.common.model.SurveyQues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SurveyQuesMapper extends BaseMapper<SurveyQues> {
    Page<SurveyQues> getCurrentSurveyALlQues(@Param("page") IPage<SurveyQues> page, @Param("surveyQues") SurveyQues surveyQues);
}