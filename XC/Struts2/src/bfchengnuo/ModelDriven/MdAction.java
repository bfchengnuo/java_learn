package com.bfchengnuo.ModelDriven;

import com.bfchengnuo.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by 冰封承諾Andy on 2017/6/20.
 * 体验模型驱动
 *
 * 最重要的作用是：对所有的 Action 模型对象进行批处理
 * 比如：在一个总的拦截器中判断是否是(instanceof) ModelDriven，如果是就强转，调用其 getModel 方法就可以获得其要操作的对象
 *       然后就可以利用反射进行实例化....等
 *
 *  它会把 getModel 返回的对象压入栈顶，所以在 JSP 页面可以直接获取对象里的属性，不需要使用属性链了
 */
public class MdAction extends ActionSupport implements ModelDriven<User> {
    private static final long serialVersionUID = -6874431547620130396L;

    private String name;
    private User user = new User();

    public String reg() {
        return SUCCESS;
    }

    public String toRegView() {
        return "toView";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }
}
