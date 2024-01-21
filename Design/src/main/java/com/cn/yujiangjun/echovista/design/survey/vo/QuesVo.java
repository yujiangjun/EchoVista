package com.cn.yujiangjun.echovista.design.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class QuesVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -4210634181254911819L;

    private Integer id;


    /**
     * 题型code
     */
    private Integer quesCode;

    /**
     * 题型名称
     */
    private String quesName;

    /**
     * 题型名称en
     */
    private String quesNameEn;

    /**
     * 题型icon
     */
    private String icon;

    /**
     * 题型序号
     */
    private Integer quesOrder;

    /**
     * 题型输入类型  见字典表quesInputType
     */
    private String quesType;

    private Integer isDeleted;

    /**
     * 问卷类型
     */
    private String surveyType;

    private String externalData;

}
