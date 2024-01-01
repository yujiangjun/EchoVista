package com.cn.yujiangjun.echovista.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cn.yujiangjun.echovista.base.utils.ContextUtil;
import com.cn.yujiangjun.echovista.common.config.JwtConfig;
import com.cn.yujiangjun.echovista.common.constants.ErrTokenEnum;
import com.cn.yujiangjun.echovista.common.exception.TokenException;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {
    private JwtUtil() {
    }

    public static String getToken(Map<String,String> map, Integer day){
        String secret = ContextUtil.getBean(JwtConfig.class).getSecret();
        Calendar instance= Calendar.getInstance();
        instance.add(Calendar.SECOND,day);
        //创建jwt  builder
        JWTCreator.Builder builder= JWT.create();
        //payload，这里采用lambda表达式设置
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime())//指定令牌过期时间
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token合法性，不合法会抛出异常信息
     * @param token ： 前端传来的token
     */
    public static DecodedJWT verify(String token){
        String secret = ContextUtil.getBean(JwtConfig.class).getSecret();
        //如果有任何验证异常，此处都会抛出异常，因此我们可以捕获这些异常来反馈信息回前端
        try {
            return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
        } catch (SignatureVerificationException e) {
            throw new TokenException(ErrTokenEnum.SIGN_NOT_AGREEMENT);
        } catch (TokenExpiredException e) {
            throw new TokenException(ErrTokenEnum.TOKEN_EXPIRED);
        } catch (AlgorithmMismatchException e) {
           throw new TokenException(ErrTokenEnum.ALGORITHM_MISMATCH);
        } catch (Exception e) {
            throw new TokenException(ErrTokenEnum.INVALID_TOKEN);
        }
    }
}
