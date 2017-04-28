package com.bfchengnuo.factory;

/**
 * Created by 冰封承諾Andy on 4/28/2017.
 * 实际调用
 */
public class Main {
    private static UserDao dao = DaoFactory.getDaoFactory().createDao(UserDao.class);

    public static void main(String[] args) {
        //TODO
        dao.add("");
    }
}
