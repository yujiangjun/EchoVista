package com.cn.yujiangjun.echovista.design.survey.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.common.constants.CommonError;
import com.cn.yujiangjun.echovista.common.exception.SurveyException;
import com.cn.yujiangjun.echovista.design.survey.model.QuesContent;
import com.cn.yujiangjun.echovista.design.survey.service.QuesContentServiceImpl;
import com.cn.yujiangjun.echovista.design.survey.vo.GetAllContentByQuesReqVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

/**
 * 问题条目
 */
@RestController
@RequestMapping("/inner/survey/ques/content")
@AllArgsConstructor
public class SurveyQuesContentController {

    private final QuesContentServiceImpl quesContentService;

    /**
     * 增加问题条目
     *
     * @param quesContent 条目
     * @return 条目
     */
    @PostMapping("/addItem")
    public Resp<QuesContent> addItem(@RequestBody QuesContent quesContent) {
        quesContent.setContentId(UUID.randomUUID().toString());
        quesContent.setIsDeleted(DelFlagEnum.NO.getCode());
        quesContentService.save(quesContent);
        return success(quesContent);
    }

    /**
     * 增加问题条目
     *
     * @param quesContent 条目
     * @return 条目
     */
    @PostMapping("/editItem")
    public Resp<QuesContent> editItem(@RequestBody QuesContent quesContent) {
        QuesContent item = quesContentService.getById(quesContent.getId());
        if (Objects.isNull(item)) {
            throw new SurveyException(CommonError.CURRENT_QUESTION_CONTENT_NOT_EXISTS);
        }
        if (Objects.equals(DelFlagEnum.YES.getCode(), item.getIsDeleted())) {
            throw new SurveyException(CommonError.CURRENT_QUESTION_CONTENT_DELETED);
        }
        quesContentService.updateById(quesContent);
        return success(quesContent);
    }

    /**
     * 增加问题条目
     *
     * @param quesContent 条目
     * @return 条目
     */
    @PostMapping("/delItem")
    public Resp<QuesContent> delItem(@RequestBody QuesContent quesContent) {
        quesContent.setIsDeleted(DelFlagEnum.YES.getCode());
        quesContentService.updateById(quesContent);
        return success(quesContent);
    }

    /**
     * 获取该问题下的所有问题条目
     * @param reqVo 问题编号
     * @return 该问题的所有条目/选项
     */
    @PostMapping("/getAllContentByQues")
    public Resp<List<QuesContent>> getAllContentByQues(@RequestBody GetAllContentByQuesReqVo reqVo) {
        QuesContent quesContent = BeanUtil.copyProperties(reqVo, QuesContent.class);
        quesContent.setIsDeleted(DelFlagEnum.NO.getCode());
        QueryWrapper<QuesContent> queryWrapper = new QueryWrapper<>(quesContent);
        List<QuesContent> list = quesContentService.list(queryWrapper);
        return success(list);
    }
}
