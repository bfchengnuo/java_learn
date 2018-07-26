package com.bfchengnuo.SecurityDemo;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码的加密方式
 * 5 版本中，接口定义了两个方法，encode 方法是对方法加密，入参只有原始密码，而且每次获取的加密后的密码不一样；
 * 而match方法是用来验证密码和加密后密码是否一致的，如果一致则返回true。
 * 优点盐值不用用户提供，每次随机生成，多重加密——迭代SHA-256算法+密钥+随机盐来对密码加密，大大增加密码破解难度，
 * 而且接口实现简单，不存在多继承。
 * Created by 冰封承諾Andy on 2018/7/16.
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.matches(charSequence, s);
    }
}
