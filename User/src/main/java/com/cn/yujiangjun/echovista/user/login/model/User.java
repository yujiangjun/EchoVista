package com.cn.yujiangjun.echovista.user.login.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "user",schema = "public")
public class User implements Serializable {
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

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updatedTime;

    private static final long serialVersionUID = 1L;

}