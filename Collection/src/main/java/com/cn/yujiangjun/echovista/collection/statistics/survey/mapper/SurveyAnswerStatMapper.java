package com.cn.yujiangjun.echovista.collection.statistics.survey.mapper;

import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.AnswerSheetQuesStatReqVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.AnswerSheetQuesStatRespVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyAnswerStatMapper {
    List<AnswerSheetQuesStatRespVo> getAllQuesInAnswerSheet(AnswerSheetQuesStatReqVo reqVo);

}