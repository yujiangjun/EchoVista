package com.cn.yujiangjun.echovista.user.servey.api;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.common.dto.SurveyQuesDTO;
import com.cn.yujiangjun.echovista.common.mapper.CatQuestionMapper;
import com.cn.yujiangjun.echovista.common.mapper.QuesContentMapper;
import com.cn.yujiangjun.echovista.common.mapper.SurveyQuesMapper;
import com.cn.yujiangjun.echovista.common.model.CatQuestion;
import com.cn.yujiangjun.echovista.common.model.QuesContent;
import com.cn.yujiangjun.echovista.common.model.SurveyQues;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import com.cn.yujiangjun.echovista.user.servey.service.UserSurveyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyApi {

    private final UserSurveyServiceImpl userSurveyService;
    private final SurveyQuesMapper surveyQuesMapper;
    private final CatQuestionMapper catQuestionMapper;
    private final QuesContentMapper quesContentMapper;

    @PostMapping("/getInfoById")
    public UserSurvey getInfoById(@RequestBody UserSurvey survey) {
        survey.setIsDeleted(DelFlagEnum.NO.getCode());
        return userSurveyService.getById(survey);
    }

    @PostMapping("/getInfoBySurveyId")
    public UserSurvey getInfoBySurveyId(@RequestBody UserSurvey survey) {
        survey.setIsDeleted(DelFlagEnum.NO.getCode());
        LambdaQueryWrapper<UserSurvey> queryWrapper = new LambdaQueryWrapper<>(survey);
        return userSurveyService.getOne(queryWrapper);
    }

    @PostMapping("/getQuestions")
    public List<SurveyQuesDTO> getQuestions(@RequestBody UserSurvey req) {
        LambdaQueryWrapper<SurveyQues> quesLambdaQueryWrapper = new LambdaQueryWrapper<SurveyQues>()
                .eq(SurveyQues::getSurveyId, req.getUserSurveyId())
                .eq(SurveyQues::getIsDeleted, DelFlagEnum.NO.getCode());
        List<SurveyQues> questions = surveyQuesMapper.selectList(quesLambdaQueryWrapper);
        if (CollUtil.isEmpty(questions)) {
            return ListUtil.empty();
        }
        List<SurveyQuesDTO> res = new ArrayList<>();
        questions.forEach(t -> {
            SurveyQuesDTO info = new SurveyQuesDTO();
            info.setSurveyQues(t);
            LambdaQueryWrapper<CatQuestion> catQuestionLambdaQueryWrapper = new LambdaQueryWrapper<CatQuestion>()
                    .eq(CatQuestion::getQuesCode, t.getQuesCode())
                    .eq(CatQuestion::getIsDeleted, DelFlagEnum.NO.getCode());
            CatQuestion catQuestion = catQuestionMapper.selectOne(catQuestionLambdaQueryWrapper);
            info.setCatQuestion(catQuestion);

            LambdaQueryWrapper<QuesContent> quesContentLambdaQueryWrapper = new LambdaQueryWrapper<QuesContent>()
                    .eq(QuesContent::getQuesId, t.getQuesId())
                    .eq(QuesContent::getIsDeleted, DelFlagEnum.NO.getCode());
            List<QuesContent> quesContentList = quesContentMapper.selectList(quesContentLambdaQueryWrapper);
            info.setQuesItems(quesContentList);
            res.add(info);
        });
        return res;
    }
}
