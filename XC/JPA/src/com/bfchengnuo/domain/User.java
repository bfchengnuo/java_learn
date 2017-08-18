package com.bfchengnuo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 冰封承諾Andy on 2017/8/17.
 * 一对多的映射、
 * 用户可以对应多个订单，一个订单只能对应一个用户
 * OneToMany 中的 One 方
 */
@Entity
@Table(name = "users")
public class User {
    private Integer id;
    private String name;
    private Set<Order> orders = new HashSet<>();

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    // 只为方便测试添加
    public void addItem(Order order) {
        order.setUser(this);
        this.orders.add(order);
    }
}
