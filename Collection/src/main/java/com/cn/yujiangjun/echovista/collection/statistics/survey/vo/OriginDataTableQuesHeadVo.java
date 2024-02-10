package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class OriginDataTableQuesHeadVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3978975648794427261L;
    /**
     * 问题id
     */
    private String quesId;
    /**
     * 问题标题
     */
    private String quesTitle;
}
