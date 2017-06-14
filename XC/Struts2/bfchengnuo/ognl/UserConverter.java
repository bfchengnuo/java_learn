package com.bfchengnuo.ognl;

import com.bfchengnuo.domain.User;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/6/13.
 * 类型转换器
 * 达到在 JSP 页面输入 xxx-xxx-xxx 自动整进 Map 集合
 */
public class UserConverter extends StrutsTypeConverter {
    // 字符串转成对象，客户端提交时
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        if (strings != null && strings.length > 0) {
            String[] ss = strings[0].split("-");
            if (ss.length > 0) {
                User user = new User();
                user.setName(ss[0]);
                user.setName(ss[1]);
                return user;
            }
        }
        return null;
    }

    // 对象转成对象，服务器返回时
    @Override
    public String convertToString(Map map, Object o) {
        // 直接调用自定义的 tostring 方法
        return o.toString();
    }
}
