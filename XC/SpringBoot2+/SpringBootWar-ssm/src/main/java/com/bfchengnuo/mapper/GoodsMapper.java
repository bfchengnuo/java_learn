package com.bfchengnuo.mapper;

import org.springframework.stereotype.Repository;

import com.bfchengnuo.bean.Goods;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午3:24:20
 */
@Repository
public interface GoodsMapper {

	int add(Goods goods);
}
