package com.edut.dao;

import java.util.List;

import com.edut.pojo.Order;

public interface OrderMapper {
	
	/**
	 * 查询订单表中的所有订单信息
	 */
	public List<Order> findAll() ;
	
	public  void delete(Order order) ;
	
	public void insert(Order order) ;
	
	public void update(Order order ) ;
}
