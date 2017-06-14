package com.bfchengnuo.ognl;

import com.bfchengnuo.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2017/6/12.
 * OGNL 表达式相关
 */
public class OgnlAction extends ActionSupport {
    private static final long serialVersionUID = 1376400932846049786L;

    // list 也是如此，如果有泛型就会自动转换
    private String[] names = new String[2];
    private List nameList; // 没有泛型的 List
    private Map nameMap; // 没有泛型的 Map

    private User user;


    public String execute() {
        initData();
        return SUCCESS;
    }

    private void initData() {
        // 往各个域中存储数据
        ServletActionContext.getRequest().setAttribute("name","request-name");
        ServletActionContext.getRequest().getSession().setAttribute("name","session-name");
        ServletActionContext.getServletContext().setAttribute("name","application-name");
        ServletActionContext.getContext().getValueStack().set("name","request-name");

        popList();
    }

    // 填充 List
    private void popList() {
        nameList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("Loli-No" + i);
            user.setAge((i+8) + "");
            nameList.add(user);
        }
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List getNameList() {
        return nameList;
    }

    public void setNameList(List nameList) {
        this.nameList = nameList;
    }

    public Map getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map nameMap) {
        this.nameMap = nameMap;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
