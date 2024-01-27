package com.cn.yujiangjun.echovista.design.survey.model;

import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 问题内容表
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class QuesContent extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 5604094863633069829L;
    private Integer id;

    /**
    * 问题内容id
    */
    private String contentId;

    /**
    * 问题id
    */
    private Integer quesId;

    /**
    * 问题显示
    */
    private Integer contentItemLabel;

    /**
    * 问题内容value
    */
    private String contentItemValue;

    /**
    * 序号
    */
    private Integer contentOrder;

    private Integer isDeleted;

}