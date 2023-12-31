package com.cn.yujiangjun.echovista.user.login.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.user.exception.LoginException;
import com.cn.yujiangjun.echovista.user.login.mapper.UserMapper;
import com.cn.yujiangjun.echovista.user.login.model.User;
import com.cn.yujiangjun.echovista.user.login.vo.req.LoginReqVO;
import com.cn.yujiangjun.echovista.user.login.vo.res.LoginResVO;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.cn.yujiangjun.echovista.user.enums.ErrorEnums.LoginEnum.*;

@Service
public class LoginService extends ServiceImpl<UserMapper, User> {
    public LoginResVO login(LoginReqVO req) {
        if (StrUtil.isBlankIfStr(req.userId()) || StrUtil.isBlankIfStr(req.password())) {
            throw new LoginException(LOGIN_PARAM_LOSE);
        }
        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getUserId, req.userId()));
        String password = Optional.ofNullable(one).orElseThrow(() -> new LoginException(CURRENT_USER_NOT_EXIST)).getPassword();
        if (!Objects.equals(password, req.password())) {
            throw new LoginException(LOGIN_PASSWORD_ERROR);
        }
        return new LoginResVO(one.getUserId(), "token");
    }

    public void logout() {

    }
}
