package com.cn.yujiangjun.echovista.design.survey.vo;

import com.cn.yujiangjun.echovista.common.model.QuesContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetAllQuesFullInfoRespVo extends QuesContent implements Serializable {
    @Serial
    private static final long serialVersionUID = 4506731646333638864L;

    private List<QuesContent> quesContentList;
}
