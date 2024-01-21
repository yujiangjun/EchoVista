package com.cn.yujiangjun.echovista.design.survey.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.design.survey.mapper.CatQuestionMapper;
import com.cn.yujiangjun.echovista.design.survey.model.CatQuestion;
import com.cn.yujiangjun.echovista.design.survey.vo.CatVo;
import com.cn.yujiangjun.echovista.design.survey.vo.QuesVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatQuestionLibServiceImpl extends ServiceImpl<CatQuestionMapper, CatQuestion> {

    private final CatQuestionMapper catQuestionMapper;
    public List<CatVo> getAllQuestions() {
        List<CatQuestion> allQuestions = catQuestionMapper.getAllQuestions();
        List<CatVo> res = new ArrayList<>();
        if (CollUtil.isEmpty(allQuestions)){
            return CollUtil.empty(List.class);
        }
        Map<Integer, List<CatQuestion>> catMap = allQuestions.stream().collect(Collectors.groupingBy(CatQuestion::getCatCode));
        catMap.values().forEach(t->{
            CatVo cat = new CatVo();
            cat.setCatCode(t.getFirst().getCatCode());
            cat.setCatName(t.getFirst().getCatName());
            cat.setIcon(t.getFirst().getIcon());
            cat.setQuesOrder(t.getFirst().getQuesOrder());
            if (CollUtil.isNotEmpty(t)){
                cat.setQuestions(t.stream().map(ques->BeanUtil.copyProperties(ques, QuesVo.class)).toList());
            }
            res.add(cat);
        });
        return res;
    }
}
