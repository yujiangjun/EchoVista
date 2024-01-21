package com.cn.yujiangjun.echovista.design.survey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.yujiangjun.echovista.design.survey.model.CatQuestion;
import com.cn.yujiangjun.echovista.design.survey.vo.CatVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CatQuestionMapper extends BaseMapper<CatQuestion> {
    List<CatQuestion> getAllQuestions();

}