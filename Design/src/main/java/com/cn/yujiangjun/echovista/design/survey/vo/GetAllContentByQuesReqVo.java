package com.cn.yujiangjun.echovista.design.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 根据问题id查询所有的问题条目
 */
@Data
public class GetAllContentByQuesReqVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 4443805405983210964L;

    private String quesId;
}
