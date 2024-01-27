package com.cn.yujiangjun.echovista.design.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 查询问卷下所有的问题以及条目
 */
@Data
public class GetAllQuesFullInfoReqVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 8684242277340341561L;
    private String surveyId;
}
