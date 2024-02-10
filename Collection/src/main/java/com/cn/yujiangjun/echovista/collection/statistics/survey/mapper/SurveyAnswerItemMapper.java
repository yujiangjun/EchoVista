package com.cn.yujiangjun.echovista.collection.statistics.survey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswerItem;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.RawDataTableReqVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.RawDataTableRespVo;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.OriginDataTableQuesHeadVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyAnswerItemMapper extends BaseMapper<SurveyAnswerItem> {
    List<OriginDataTableQuesHeadVo> getRawDataTableHeader(RawDataTableReqVo reqVo);

    List<RawDataTableRespVo> getRawInputDataForTable(RawDataTableReqVo reqVo);
}