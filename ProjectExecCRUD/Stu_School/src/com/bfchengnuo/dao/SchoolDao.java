package com.bfchengnuo.dao;

import com.bfchengnuo.po.School;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public interface SchoolDao {
    void addSchool(School school);

    void delSchoolById(int id);

    School querySchoolById(int id);

    List<School> queryAll();

}
