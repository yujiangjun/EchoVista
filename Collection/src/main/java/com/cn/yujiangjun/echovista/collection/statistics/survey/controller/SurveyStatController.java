package com.cn.yujiangjun.echovista.collection.statistics.survey.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.base.web.vo.RespVO;
import com.cn.yujiangjun.echovista.collection.statistics.survey.service.SurveyStatServiceImpl;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey/stat")
@AllArgsConstructor
public class SurveyStatController {


    private final SurveyStatServiceImpl surveyStatService;

    /**
     * 获取 每个问卷具体的问题信息
     *
     * @param reqVo 文件id
     * @return 问题信息列表
     */
    @PostMapping("/getRawDataTableHeader")
    public Resp<List<RawDataTableQuesHeadVo>> getRawDataTableHeader(@RequestBody RawDataTableReqVo reqVo) {
        return RespVO.success(surveyStatService.getRawDataTableHeader(reqVo));
    }

    /**
     * 获取每份问卷用户的输入内容
     *
     * @param reqVo 问卷id
     * @return 每份问卷的用户输入数据
     */
    @PostMapping("/getRawInputDataForTable")
    public Resp<List<RawDataTableRespVo>> getRawInputDataForTable(@RequestBody RawDataTableReqVo reqVo) {
        return RespVO.success(surveyStatService.getRawInputDataForTable(reqVo));
    }

    /**
     * 统计每道题的统计数据
     * @param reqVo 问卷id
     * @return 每道题的统计数据
     */
    @PostMapping("/getAllQuesStatInAnswerSheet")
    public Resp<List<AnswerSheetQuesStatRespVo>> getAllQuesInAnswerSheet(@RequestBody AnswerSheetQuesStatReqVo reqVo){
        return RespVO.success(surveyStatService.getAllQuesInAnswerSheet(reqVo));
    }

    /**
     * 统计每道题的统计数据
     * @param reqVo 问卷id
     * @return 每道题的统计数据
     */
    @PostMapping("/getAllQuesItemStatInAnswerSheet")
    public Resp<List<AnswerSheetQuesItemStatRespVo>> getAllQuesItemStatInAnswerSheet(@RequestBody AnswerSheetQuesItemStatReqVo reqVo){
        return RespVO.success(surveyStatService.getAllQuesItemStatInAnswerSheet(reqVo));
    }
}
