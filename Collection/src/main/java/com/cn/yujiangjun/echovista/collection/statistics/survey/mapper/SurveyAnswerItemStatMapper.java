package com.cn.yujiangjun.echovista.collection.statistics.survey.mapper;

import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.AnswerSheetQuesItemStatReqVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.AnswerSheetQuesItemStatRespVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyAnswerItemStatMapper {
    List<AnswerSheetQuesItemStatRespVo> getAllQuesItemStatInAnswerSheet(AnswerSheetQuesItemStatReqVo reqVo);
}