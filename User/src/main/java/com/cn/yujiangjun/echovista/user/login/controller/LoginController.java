package com.cn.yujiangjun.echovista.user.login.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.user.login.service.LoginService;
import com.cn.yujiangjun.echovista.user.login.vo.req.LoginReqVO;
import com.cn.yujiangjun.echovista.user.login.vo.res.LoginResVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/inner/user/login")
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/")
    public Resp<LoginResVO> login(@RequestBody LoginReqVO req) {
        return success(loginService.login(req));
    }

    @PostMapping("/logout")
    public Resp<Void> logout() {
        loginService.logout();
        return success(null);
    }
}
