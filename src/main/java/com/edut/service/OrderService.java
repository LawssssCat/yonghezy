package com.edut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edut.dao.DoorMapper;
import com.edut.dao.OrderMapper;
import com.edut.pojo.Door;
import com.edut.pojo.Order;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderDao ; 
	
	@Autowired
	private DoorMapper doorDao ; 
	
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public void getAllOrderListAndDoorInfo(Model model) {
		
		List<Order> orderList = orderDao.findAll();
		
		List<Door> doorList = doorDao.findAll();
		
		model.addAttribute("orderList", orderList) ; 
		model.addAttribute("doorList", doorList) ; 
	}
	
	/**
	 * 根据 id 删除订单信息
	 * @return
	 */
	public void orderDelete(Order order) {
		orderDao.delete(order);
	}
	
	public List<Door> findAllDoor() {
		return doorDao.findAll();
	}
	/**
	 * 新增订单信息
	 * @return
	 */
	public void orderAdd(Order order   ) {
		orderDao.insert(order);
	}

	public Order getOrderById(Integer id) {
		List<Order> list = orderDao.findAll();
		if(list == null ) {
			return null ; 
		}
		
		for (Order order : list) {
			if(order.getId().equals(id)) {
				return order ; 
			}
		}
		return null ; 
	}
	

	public void orderUpdate(Order order) {
		orderDao.update(order);
	}


}