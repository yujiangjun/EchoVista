package com.cn.yujiangjun.echovista.user.servey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GetMySurveyReqVO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8866578254010194623L;
    private String userId;
}
