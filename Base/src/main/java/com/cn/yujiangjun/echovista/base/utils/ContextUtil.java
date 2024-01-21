package com.cn.yujiangjun.echovista.base.utils;

import org.springframework.context.ApplicationContext;

public class ContextUtil {
    private static ApplicationContext context;

    public static void setContext(ApplicationContext context) {
        ContextUtil.context = context;
    }

    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    public static <T> T getBean(Class<T> clazz,String beanName){
        return context.getBean(beanName,clazz);
    }

}
