package com.cn.yujiangjun.echovista.collection.statistics.survey.service;

import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerItemMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.RawDataTableReqVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.RawDataTableRespVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.OriginDataTableQuesHeadVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyStatServiceImpl {

    private final SurveyAnswerItemMapper surveyAnswerItemMapper;
    public List<OriginDataTableQuesHeadVo> getRawDataTableHeader(RawDataTableReqVo reqVo) {
        return surveyAnswerItemMapper.getRawDataTableHeader(reqVo);
    }

    public List<RawDataTableRespVo> getRawInputDataForTable(RawDataTableReqVo reqVo) {
        return surveyAnswerItemMapper.getRawInputDataForTable(reqVo);
    }
}
