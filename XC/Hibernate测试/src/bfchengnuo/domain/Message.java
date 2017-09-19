package com.bfchengnuo.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 冰封承諾Andy on 2017/7/8.
 * 使用注解配置 bean 测试
 */
@Entity  // 标识这是个实体
@Table(name="message")  // 对应的表名
public class Message implements Serializable {
    private int id;
    private String msg;
    /*
    * JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    * TABLE：使用一个特定的数据库表格来保存主键。
    * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    * IDENTITY：主键由数据库自动生成（主要是自动增长型）
    * AUTO：主键由程序控制。
    *
    *
    * auto: 当数据库中  不存在 这张表的时候可以用它建表的时候, 制定自增的方式,  存在的时候插入数据还用它就会出错了
    * identity: 使用SQL Server 和 MySQL 的自增字段
    *
    * */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "msg")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
