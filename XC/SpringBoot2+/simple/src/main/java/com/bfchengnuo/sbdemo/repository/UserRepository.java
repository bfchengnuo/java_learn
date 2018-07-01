package com.bfchengnuo.sbdemo.repository;

import com.bfchengnuo.sbdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 冰封承諾Andy on 2018/1/16.
 */
@Repository
public class UserRepository {

    /**
     * 考虑高并发的情况选用 ConcurrentMap，线程安全
     */
    private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象到内存
     *
     * @param user
     * @return 成功返回 <code>true</code>
     */
    public boolean save(User user) {
        // id 从 1 开始自增
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    /**
     * 返回所有的用户列表
     * @return
     */
    public Collection<User> findAll() {
        return repository.values();
    }
}
