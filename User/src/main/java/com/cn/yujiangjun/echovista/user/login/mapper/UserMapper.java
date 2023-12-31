package com.cn.yujiangjun.echovista.user.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.yujiangjun.echovista.user.login.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}