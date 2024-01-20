package com.cn.yujiangjun.echovista.user.login.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.common.config.JwtConfig;
import com.cn.yujiangjun.echovista.common.utils.JwtUtil;
import com.cn.yujiangjun.echovista.user.exception.LoginException;
import com.cn.yujiangjun.echovista.user.login.mapper.UserMapper;
import com.cn.yujiangjun.echovista.user.login.model.User;
import com.cn.yujiangjun.echovista.user.login.vo.req.LoginReqVO;
import com.cn.yujiangjun.echovista.user.login.vo.res.LoginResVO;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.cn.yujiangjun.echovista.user.enums.ErrorEnums.LoginEnum.*;

@Service
@AllArgsConstructor
public class LoginService extends ServiceImpl<UserMapper, User> {

    private final JwtConfig jwtConfig;
    private final RedisTemplate<String,Object> redisTemplate;

    public LoginResVO login(LoginReqVO req) {
        if (StrUtil.isBlankIfStr(req.userId()) || StrUtil.isBlankIfStr(req.password())) {
            throw new LoginException(LOGIN_PARAM_LOSE);
        }
        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getUserId, req.userId()));
        Optional<User> optionalUser = Optional.ofNullable(one);
        String password = optionalUser.orElseThrow(() -> new LoginException(CURRENT_USER_NOT_EXIST)).getPassword();
        if (!Objects.equals(password, req.password())) {
            throw new LoginException(LOGIN_PASSWORD_ERROR);
        }
        String token = JwtUtil.getToken(BeanUtil.beanToMap(one, false, true), jwtConfig.getExpire());
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps(token);
        /* todo 这里不是原子性，考虑使用lua脚本 */
        hashOps.expire(7,TimeUnit.DAYS);
        hashOps.putAll(BeanUtil.beanToMap(one,true,false));
        return new LoginResVO(optionalUser.get().getUserId(), token);
    }

    public void logout() {

    }
}
