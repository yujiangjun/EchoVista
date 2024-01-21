package com.cn.yujiangjun.echovista.design.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 题目分类库
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CatQuestion extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 7966393645936875411L;
    private Integer id;

    /**
    * 分类code
    */
    private Integer catCode;

    /**
    * 分类名称
    */
    private String catName;

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