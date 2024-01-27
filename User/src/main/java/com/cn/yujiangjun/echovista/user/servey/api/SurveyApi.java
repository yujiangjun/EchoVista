package com.cn.yujiangjun.echovista.user.servey.api;

import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import com.cn.yujiangjun.echovista.user.servey.service.UserSurveyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyApi {

    private final UserSurveyServiceImpl userSurveyService;
    @PostMapping("/getInfoById")
    public UserSurvey getInfoById(@RequestBody UserSurvey survey){
        survey.setIsDeleted(DelFlagEnum.NO.getCode());
        return userSurveyService.getById(survey);
    }
}
