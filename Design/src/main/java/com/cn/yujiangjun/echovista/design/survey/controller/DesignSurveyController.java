package com.cn.yujiangjun.echovista.design.survey.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.base.web.vo.PageReqVo;
import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.design.survey.model.SurveyQues;
import com.cn.yujiangjun.echovista.design.survey.service.SurveyQuesServiceImpl;
import com.cn.yujiangjun.echovista.design.survey.vo.GetAllContentByQuesReqVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/design/survey")
@AllArgsConstructor
public class DesignSurveyController {

    private final SurveyQuesServiceImpl surveyQuesService;

    /**
     * 添加问题
     *
     * @param surveyQues 问题
     * @return 主键
     */
    @PostMapping("/addQues")
    public Resp<SurveyQues> addQues(@RequestBody SurveyQues surveyQues) {
        surveyQues.setQuesId(UUID.randomUUID().toString());
        surveyQues.setQuesCode(surveyQues.getSurveyId() + "_" + surveyQues.getQuesOrder());
        surveyQues.setIsDeleted(DelFlagEnum.NO.getCode());
        surveyQuesService.save(surveyQues);
        return success(surveyQues);
    }

    /**
     * 编辑 问题
     * @param surveyQues 问题
     * @return 更新后的问题
     */
    @PostMapping("/editQues")
    public Resp<SurveyQues> editQues(@RequestBody SurveyQues surveyQues) {
        SurveyQues ques = surveyQuesService.getById(surveyQues.getId());
        if (Objects.isNull(ques)) {
            throw new SurveyException(CommonError.CURRENT_QUESTION_NOT_EXISTS);
        }
        if (Objects.equals(DelFlagEnum.YES.getCode(), ques.getIsDeleted())) {
            throw new SurveyException(CommonError.CURRENT_QUESTION_DELETED);
        }
        surveyQuesService.updateById(surveyQues);
        return success(surveyQues);
    }

    /**
     * 删除问题
     * @param surveyQues 问题
     */
    @PostMapping("/delQues")
    public Resp<Void> delQues(@RequestBody SurveyQues surveyQues) {
        SurveyQues ques = surveyQuesService.getById(surveyQues.getId());
        if (Objects.isNull(ques)) {
            throw new SurveyException(CommonError.CURRENT_QUESTION_NOT_EXISTS);
        }
        ques.setIsDeleted(DelFlagEnum.YES.getCode());
        surveyQuesService.updateById(surveyQues);
        return success(null);
    }

    @PostMapping("/getCurrentSurveyAllQues")
    public Resp<Page<SurveyQues>> getCurrentSurveyALlQues(@RequestBody PageReqVo<GetAllContentByQuesReqVo> reqVo){
        SurveyQues surveyQues = BeanUtil.copyProperties(reqVo.getPayload(), SurveyQues.class);
        surveyQues.setIsDeleted(DelFlagEnum.NO.getCode());
        return success(surveyQuesService.getCurrentSurveyALlQues(surveyQues,reqVo.getPage(),reqVo.getPageSize()));
    }
}
