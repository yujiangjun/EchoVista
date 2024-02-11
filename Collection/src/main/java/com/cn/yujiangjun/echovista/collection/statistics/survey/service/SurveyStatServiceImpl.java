package com.cn.yujiangjun.echovista.collection.statistics.survey.service;

import cn.hutool.core.collection.CollUtil;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerItemMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerItemStatMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.mapper.SurveyAnswerStatMapper;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SurveyStatServiceImpl {

    private final SurveyAnswerItemMapper surveyAnswerItemMapper;

    private final SurveyAnswerStatMapper surveyAnswerStatMapper;

    private final SurveyAnswerItemStatMapper surveyAnswerItemStatMapper;

    public List<RawDataTableQuesHeadVo> getRawDataTableHeader(RawDataTableReqVo reqVo) {
        return surveyAnswerItemMapper.getRawDataTableHeader(reqVo);
    }

    public List<RawDataTableRespVo> getRawInputDataForTable(RawDataTableReqVo reqVo) {
        return surveyAnswerItemMapper.getRawInputDataForTable(reqVo);
    }

    /**
     * 统计答卷中每道题答题人的数量
     *
     * @param reqVo 问卷id
     * @return 每道题的统计数据列表
     */
    public List<AnswerSheetQuesStatRespVo> getAllQuesInAnswerSheet(AnswerSheetQuesStatReqVo reqVo) {
        return surveyAnswerStatMapper.getAllQuesInAnswerSheet(reqVo);
    }

    /**
     * 统计当前问题每个选项的统计数据
     *
     * @param reqVo 问题id
     * @return 每个选项的统计数据
     */
    public List<AnswerSheetQuesItemStatRespVo> getAllQuesItemStatInAnswerSheet(AnswerSheetQuesItemStatReqVo reqVo) {
        List<AnswerSheetQuesItemStatRespVo> res = surveyAnswerItemStatMapper.getAllQuesItemStatInAnswerSheet(reqVo);
        if (CollUtil.isEmpty(res)) {
            return res;
        }
        int sumAnswerCount = res.stream().mapToInt(AnswerSheetQuesItemStatRespVo::getAnswerCount).sum();
        if (sumAnswerCount == 0) {
            res.forEach(t -> t.setAnswerPercentage("0%"));
        } else {
            res.forEach(t -> {
                if (Objects.isNull(t.getAnswerCount()) || 0 == t.getAnswerCount()) {
                    t.setAnswerPercentage("0%");
                } else {
                    BigDecimal sum = BigDecimal.valueOf(sumAnswerCount);
                    BigDecimal count = BigDecimal.valueOf(t.getAnswerCount());
                    double v = count.divide(sum, 2, RoundingMode.FLOOR).doubleValue();
                    t.setAnswerPercentage(STR."\{v}%");
                }
            });
        }
        return res;
    }
}
