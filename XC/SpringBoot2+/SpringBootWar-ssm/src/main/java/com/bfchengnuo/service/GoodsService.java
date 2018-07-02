package com.bfchengnuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfchengnuo.bean.Goods;
import com.bfchengnuo.mapper.GoodsMapper;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月29日 下午3:34:55
 */
@Service
public class GoodsService {

	@Autowired
	private GoodsMapper mapper;
	
	@Transactional
	public int add(Goods goods) {
		return mapper.add(goods);
	}
}
