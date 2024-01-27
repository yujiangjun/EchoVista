package com.cn.yujiangjun.echovista.collection.statistics.survey.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswer;
import com.cn.yujiangjun.echovista.collection.statistics.survey.service.SurveyAnswerServiceImpl;
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

    @PostMapping("/addSurveyAnswer")
    public Resp<SurveyAnswer> addSurveyAnswer(@RequestBody SurveyAnswer surveyAnswer) {
        return success(surveyAnswerService.addSurveyAnswer(surveyAnswer));
    }
}