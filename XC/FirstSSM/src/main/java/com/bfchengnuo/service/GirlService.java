package com.bfchengnuo.service;

import com.bfchengnuo.mapper.GirlMapper;
import com.bfchengnuo.pojo.Girl;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 冰封承諾Andy on 2017/10/17.
 */
@Service
public class GirlService {
    @Resource
    private GirlMapper girlMapper;

    public List<Girl> queryGirlList() {
        // 指定排序方式
        Example example = new Example(Girl.class);
        example.setOrderByClause("age DESC");
        // return girlMapper.selectAll();
        return girlMapper.selectByExample(example);
    }

}
