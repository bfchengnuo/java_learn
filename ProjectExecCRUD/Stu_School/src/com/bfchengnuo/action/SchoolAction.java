package com.bfchengnuo.action;

import com.bfchengnuo.po.School;
import com.bfchengnuo.service.SchooleService;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class SchoolAction {
    private SchooleService schooleService = new SchooleService();

    private List<School> list;
    private School sc;

    public String querySchool() throws Exception {
        list = schooleService.queryAll();
        return "success";
    }

    public List<School> getList() {
        return list;
    }

    public String addSchool() throws Exception {
        if (sc != null) {
            schooleService.addSchool(sc);
        }
        return "success";
    }

    public School getSc() {
        return sc;
    }

    public void setSc(School sc) {
        this.sc = sc;
    }
}
