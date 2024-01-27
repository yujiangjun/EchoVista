package com.cn.yujiangjun.echovista.user.servey.service;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.user.servey.mapper.UserSurveyMapper;
import com.cn.yujiangjun.echovista.common.model.UserSurvey;
import com.cn.yujiangjun.echovista.user.servey.vo.GetMySurveyReqVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserSurveyServiceImpl extends ServiceImpl<UserSurveyMapper, UserSurvey> {

    private final UserSurveyMapper userSurveyMapper;

    public List<UserSurvey> getMySurveyList(GetMySurveyReqVO req) {
        if (CharSequenceUtil.isBlank(req.getUserId())){
            throw new SurveyException(CommonError.PARAMS_NOT_EXISTS);
        }
        LambdaQueryWrapper<UserSurvey> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserSurvey::getUserId,req.getUserId())
                .eq(UserSurvey::getIsDeleted, DelFlagEnum.NO.getCode());
        return list(queryWrapper);
    }
}
