package com.cn.yujiangjun.echovista.user.login.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.yujiangjun.echovista.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user",schema = "public")
public class User extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -1869266222333380878L;
    /**
    * 主键
    */
    @TableId
    private Long id;

    /**
    * 用户id
    */
    private String userId;

    private String password;

    /**
    * 用户名
    */
    private String userName;

    private String email;

    private String fullName;

    /**
    * 是否激活 1是 0否
    */
    private Integer isActive;

    /**
    * 是否删除 1是0否
    */
    private Integer isDeleted;


}