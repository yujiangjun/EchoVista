package com.cn.yujiangjun.echovista.design.survey.vo;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CatVo implements Serializable {
    @Serial
    private static final long serialVersionUID = -730029009515623189L;

    private Integer id;

    private Integer catCode;
    private String catName;
    private String icon;
    private Integer quesOrder;
    /**
     * 体型
     */
    List<QuesVo> questions;
}
