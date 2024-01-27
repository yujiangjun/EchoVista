package com.cn.yujiangjun.echovista.user.servey.controller;

import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.constants.SurveyStatusEnum;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import com.cn.yujiangjun.echovista.user.servey.service.UserSurveyServiceImpl;
import com.cn.yujiangjun.echovista.user.servey.vo.GetMySurveyReqVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/survey")
@AllArgsConstructor
public class SurveyController {

    private final UserSurveyServiceImpl userSurveyService;



    @PostMapping("/getMySurveys")
    public Resp<List<UserSurvey>> getMySurveyList(@RequestBody GetMySurveyReqVO req){
        return success(userSurveyService.getMySurveyList(req));
    }

    @PostMapping("/createSurvey")
    public Resp<UserSurvey> createSurvey(@RequestBody UserSurvey userSurvey){
        userSurvey.setStatus(SurveyStatusEnum.INIT.getCode());
        userSurvey.setIsDeleted(DelFlagEnum.NO.getCode());
        userSurveyService.save(userSurvey);
        return success(userSurvey);
    }

    @PostMapping("/editSurvey")
    public Resp<UserSurvey> editSurvey(@RequestBody UserSurvey userSurvey){
        if (Objects.isNull(userSurvey.getId())){
            throw new SurveyException(CommonError.PARAMS_NOT_EXISTS);
        }
        UserSurvey survey = userSurveyService.getById(userSurvey.getId());
        if (Objects.equals(survey.getIsDeleted(), DelFlagEnum.YES.getCode())){
            throw new SurveyException(CommonError.DEL_FLAG_YES_FORBIDDEN_OPERATION);
        }
        if (Objects.equals(survey.getStatus(),SurveyStatusEnum.INIT.getCode())
        || Objects.equals(survey.getStatus(),SurveyStatusEnum.DRAFT.getCode())){
            throw new SurveyException(CommonError.SURVEY_CUR_STATUS_FORBIDDEN_EDIT);
        }
        userSurveyService.updateById(userSurvey);
        return success(userSurvey);
    }

    @PostMapping("/delSurvey")
    public Resp<Void> delSurvey(@RequestBody UserSurvey userSurvey){
        if (Objects.isNull(userSurvey.getId())){
            throw new SurveyException(CommonError.PARAMS_NOT_EXISTS);
        }
        UserSurvey survey = userSurveyService.getById(userSurvey.getId());
        if (Objects.equals(survey.getStatus(),SurveyStatusEnum.PUBLISH.getCode())){
            throw new SurveyException(CommonError.SURVEY_CUR_STATUS_FORBIDDEN_EDIT);
        }

        if (Objects.equals(survey.getIsDeleted(), DelFlagEnum.YES.getCode())){
            return  success(null);
        }
        survey.setIsDeleted(DelFlagEnum.YES.getCode());
        userSurveyService.updateById(survey);
        return success(null);
    }
}
