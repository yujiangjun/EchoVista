package com.cn.yujiangjun.echovista.collection.statistics.survey.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.collection.statistics.survey.model.SurveyAnswerItem;
import com.cn.yujiangjun.echovista.collection.statistics.survey.service.SurveyAnswerItemServiceImpl;
import com.cn.yujiangjun.echovista.collection.statistics.survey.vo.SurveyAnswerItemVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/inner/survey/answer/item")
@AllArgsConstructor
public class SurveyAnswerItemController {

    private final SurveyAnswerItemServiceImpl surveyAnswerItemService;
    @PostMapping("/addItem")
    public Resp<SurveyAnswerItem> addItem(@RequestBody SurveyAnswerItemVo surveyAnswerItemVo){
        return success(surveyAnswerItemService.addItem(surveyAnswerItemVo));
    }
}
