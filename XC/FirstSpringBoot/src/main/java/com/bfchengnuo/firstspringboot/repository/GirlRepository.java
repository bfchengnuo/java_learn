package com.bfchengnuo.firstspringboot.repository;

import com.bfchengnuo.firstspringboot.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/14.
 * 用来操作数据库，继承接口 JpaRepository 即可
 * 泛型写上实体类和 id 的类型
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    // 扩展接口，通过指定的条件来查询
    List<Girl> findByAge (Integer age);
}
