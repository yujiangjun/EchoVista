package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RawInputDataTableVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3978975648794427261L;
    /**
     * 问题id
     */
    private String quesId;
    /**
     * 问答id
     */
    private String answerId;
    /**
     * 问答内容，当一个题目的回答有多个，使用|连接
     */

    private String answerItemValues;
}
