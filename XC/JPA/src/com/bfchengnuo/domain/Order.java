package com.bfchengnuo.domain;

import javax.persistence.*;

/**
 * Created by 冰封承諾Andy on 2017/8/17.
 * OneToMany 中的 Many 方
 */
@Entity
@Table(name = "orders")
public class Order {
    private Integer id;
    private String orderName;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    // 通过 optional 设置为必填项
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
