package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 删除答卷
 */
@Data
public class DelAnswerSheetReqVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3073666860599391994L;

    private Integer answerId;
}
