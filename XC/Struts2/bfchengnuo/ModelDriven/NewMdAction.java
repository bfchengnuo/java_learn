package com.bfchengnuo.ModelDriven;

import com.bfchengnuo.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * Created by 冰封承諾Andy on 2017/6/20.
 * 体验模型驱动
 *
 * 模型驱动拦截器在参数拦截器之前，如果想要在模型驱动将对象压入栈顶之前初始化对象，可以使用准备拦截器
 * 需要实现 Preparable 接口，然后复写它的方法即可，此方法会在模型驱动拦截器之前调用
 * 如果需要参数数据，要用 paramsPrepareParamsStack 栈，因为默认栈准备拦截器是优于参数拦截器的
 */
public class NewMdAction extends ActionSupport implements ModelDriven<User>,Preparable {
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

    // 只想要在访问 reg 方法的时候填充数据；使用 preparedoReg 也是可以的
    public void prepareReg() throws Exception {
        User u = new User();
        u.setName("佳芷");
        u.setAge("14");
        // 在压入栈顶之前覆盖对象
        user = u;
    }

    @Override
    public void prepare() throws Exception {

    }
}
