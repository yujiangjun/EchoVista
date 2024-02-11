package com.cn.yujiangjun.echovista.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.yujiangjun.echovista.common.model.CatQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CatQuestionMapper extends BaseMapper<CatQuestion> {
    List<CatQuestion> getAllQuestions();

}