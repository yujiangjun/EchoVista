package com.cn.yujiangjun.echovista.collection.statistics.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class RawDataTableRespVo implements Serializable {

    @Serial
    private static final long serialVersionUID = -560558414961667518L;

    private String surveyId;
    /**
     * 回答序号
     */
    private Integer answerNo;
    /**
     * 答题时间
     */
    private Date answerDate;
    /**
     * ip
     */
    private String ip;
    /**
     * 归属地
     */
    private String location;
    /**
     * 用户回答题目答案
     */
    private List<RawInputDataTableVo> quesHeadList;
}
