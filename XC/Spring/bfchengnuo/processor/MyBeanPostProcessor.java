package com.bfchengnuo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by 冰封承諾Andy on 2017/7/19.
 * 自定义的后置处理器
 * AOP 思想，每个 bean 实例化时（前、后）都要调用此处理器
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        // o 就是创建出来的实例 配置文件中的 bean
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
