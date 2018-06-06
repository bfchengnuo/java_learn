package com.bfchengnuo.dao;

import com.bfchengnuo.factory.SSF;
import com.bfchengnuo.po.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 冰封承諾Andy on 2018/6/5.
 */
public class StuDaoImpl implements StuDao {
    private SqlSession session = null;

    @Override
    public void addStu(Student student) {
        try {
            session = SSF.getSession();
            session.insert("addStu", student);
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
    public void delStuById(int id) {
        try {
            session = SSF.getSession();
            session.delete("delStuById", id);
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
    public void updateStu(Student student) {
        try {
            session = SSF.getSession();
            session.update("updateStu", student);
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
    public Student queryStuById(int id) {
        try {
            session = SSF.getSession();
            Student s = session.selectOne("queryStuById", id);
            session.commit();
            return s;
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
    public List<Student> querySome(String name,Integer sid, int start, int max) {
        try {
            Map<String, Object> map = new HashMap<>();
            if (name != null && !name.equals("")) {
                map.put("name", name);
            }
            if (sid != null && sid != 0) {
                map.put("sid", sid);
            }
            map.put("start", start);
            map.put("max", max);

            session = SSF.getSession();
            List<Student> list = session.selectList("queryStuSome", map);
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

    @Override
    public int countStu(String name, Integer sid) {
        try {
            Map<String, Object> map = new HashMap<>();
            if (name != null && !name.equals("")) {
                map.put("name", name);
            }
            if (sid != null && sid != 0) {
                map.put("sid", sid);
            }
            System.out.println(map);
            session = SSF.getSession();
            int count = session.selectOne("countStu", map);
            session.commit();
            return count;
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
        return 0;
    }
}
