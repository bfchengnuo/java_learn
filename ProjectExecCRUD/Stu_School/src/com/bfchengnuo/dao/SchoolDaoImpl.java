package com.bfchengnuo.dao;

import com.bfchengnuo.factory.SSF;
import com.bfchengnuo.po.School;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class SchoolDaoImpl implements SchoolDao {
    private SqlSession session = null;


    @Override
    public void addSchool(School school) {
        try {
            session = SSF.getSession();
            session.insert("addSchool", school);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delSchoolById(int id) {
        try {
            session = SSF.getSession();
            session.delete("delSchoolById", id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public School querySchoolById(int id) {try {
        session = SSF.getSession();
        School school = session.selectOne("querySchoolById", id);
        session.commit();
        return school;
    } catch (Exception e) {
        e.printStackTrace();
        if (session != null) {
            session.rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }
        return null;
    }

    @Override
    public List<School> queryAll() {
        try {
            session = SSF.getSession();
            List<School> list = session.selectList("querySchoolAll");
            session.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
