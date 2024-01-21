package com.cn.yujiangjun.echovista.design.survey.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.design.survey.service.CatQuestionLibServiceImpl;
import com.cn.yujiangjun.echovista.design.survey.vo.CatVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/cat/ques")
@AllArgsConstructor
public class CatQuestionController {


    private final CatQuestionLibServiceImpl catQuestionLibService;

    @GetMapping("/getAllQuestions")
    public Resp<List<CatVo>> getAllQuestions(){
        return success(catQuestionLibService.getAllQuestions());
    }
}
