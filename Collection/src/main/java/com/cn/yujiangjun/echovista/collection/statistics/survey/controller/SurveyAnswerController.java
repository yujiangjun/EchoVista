package com.cn.yujiangjun.echovista.collection.statistics.survey.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.base.web.vo.RespVO;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswer;
import com.cn.yujiangjun.echovista.collection.statistics.survey.service.SurveyAnswerServiceImpl;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.DelAnswerSheetReqVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/survey/answer")
@AllArgsConstructor
public class SurveyAnswerController {

    private final SurveyAnswerServiceImpl surveyAnswerService;

    /**
     * 添加问卷答案
     * @param surveyAnswer 问卷答案
     * @return 主键id
     *
     */
    @PostMapping("/addSurveyAnswer")
    public Resp<SurveyAnswer> addSurveyAnswer(@RequestBody SurveyAnswer surveyAnswer) {
        return success(surveyAnswerService.addSurveyAnswer(surveyAnswer));
    }

    @PostMapping("/delAnswerSheet")
    public Resp<Void> delAnswer(@RequestBody DelAnswerSheetReqVo reqVo){
        surveyAnswerService.delAnswerSheet(reqVo);
        return RespVO.success(null);
    }
}
