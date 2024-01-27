package com.cn.yujiangjun.echovista.collection.statistics.survey.remote;

import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user",url = "http://localhost:8083/")
public interface SurveyRemoteService {

    @PostMapping("/survey/getInfoById")
    UserSurvey getInfoById(@RequestBody UserSurvey survey);
}
