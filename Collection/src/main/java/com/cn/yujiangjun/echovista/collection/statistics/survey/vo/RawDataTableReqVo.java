package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RawDataTableReqVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -8152258554157005848L;
    private String surveyId;
}
