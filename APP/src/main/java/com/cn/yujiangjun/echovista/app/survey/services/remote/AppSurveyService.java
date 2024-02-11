package com.cn.yujiangjun.echovista.app.survey.services.remote;

import com.cn.yujiangjun.echovista.app.survey.vo.SurveyQuesDTO;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user",url = "http://localhost:8083")
public interface AppSurveyService {

    @PostMapping("/survey/getInfoBySurveyId")
    UserSurvey getUserSurveyBySurveyId(@RequestBody UserSurvey userSurvey);

    @PostMapping("/survey/getQuestions")
    List<SurveyQuesDTO> getSurveyQuestions(@RequestBody UserSurvey userSurvey);
}
