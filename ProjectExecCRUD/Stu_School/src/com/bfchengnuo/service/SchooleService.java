package com.bfchengnuo.service;

import com.bfchengnuo.dao.SchoolDao;
import com.bfchengnuo.dao.SchoolDaoImpl;
import com.bfchengnuo.po.School;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class SchooleService {
    private SchoolDao dao = new SchoolDaoImpl();

    public void addSchool(School school) {
        dao.addSchool(school);
    }

    public void delSchoolById(int id) {
        dao.delSchoolById(id);
    }

    public School querySchoolById(int id) {
        return dao.querySchoolById(id);
    }

    public List<School> queryAll() {
        return dao.queryAll();
    }
}
