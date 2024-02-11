package com.cn.yujiangjun.echovista.app.survey.controller;

import com.cn.yujiangjun.echovista.app.survey.services.remote.AppSurveyService;
import com.cn.yujiangjun.echovista.app.survey.vo.SurveyInfoVo;
import com.cn.yujiangjun.echovista.app.survey.vo.SurveyQuesDTO;
import com.cn.yujiangjun.echovista.app.survey.vo.SurveyReqVo;
import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.base.web.vo.RespVO;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyController {

    private final AppSurveyService appSurveyService;

    @PostMapping("/getSurveyInfo")
    public Resp<SurveyInfoVo> getSurveyInfo(@RequestBody SurveyReqVo reqVo) {
        SurveyInfoVo surveyInfoVo = new SurveyInfoVo();
        UserSurvey req = new UserSurvey();
        req.setUserSurveyId(reqVo.getSurveyId());
        UserSurvey userSurvey = appSurveyService.getUserSurveyBySurveyId(req);
        surveyInfoVo.setUserSurvey(userSurvey);

        List<SurveyQuesDTO> questions = appSurveyService.getSurveyQuestions(req);
        surveyInfoVo.setQuestions(questions);
        return RespVO.success(surveyInfoVo);
    }
}
