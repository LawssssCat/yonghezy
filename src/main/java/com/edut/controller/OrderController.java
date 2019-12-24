package com.edut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edut.dao.DoorMapper;
import com.edut.dao.OrderMapper;
import com.edut.pojo.Door;
import com.edut.pojo.Order;
import com.edut.service.OrderService;

@Controller("orderController")
public class OrderController {
	
	@Autowired
	private OrderService orderService ; 
	
	/**
	 * 查询所有订单信息
	 * @return
	 */
	@RequestMapping("/orderList")
	public String orderList(Model model ) {
		
		orderService.getAllOrderListAndDoorInfo(model);
		return "order_list" ; 
	}
	
	
	/**
	 * 根据 id 删除订单信息
	 * @return
	 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Order order) {
		orderService.orderDelete(order);
		return "forward:/orderList" ; 
	}
	
	/**
	 * 新增订单信息
	 * @return
	 */
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order , Model model ) {
		try {
			orderService.orderAdd(order) ;
			return "forward:/orderList" ; 
		} catch (NumberFormatException ex) {
			model.addAttribute("updateException", ex.toString()) ;
			return "forward:/toOrderAdd" ; 
		}
	}
	
	/**
	 * 添加前，先获取全部门店信息 
	 */
	@RequestMapping("/toOrderAdd")
	public String AddBeforeFindAllDoor(Model model  ) {
		
		List<Door> doorList = orderService.findAllDoor();
		model.addAttribute("doorList", doorList) ; 
		
		
		return "forward:/order_add" ; 
	}
	
	
	/**
	 * to更新数据页面前，
	 * 先
	 * 1. 查找全部萌点
	 * 2. 寻找更新的原数据 
	 */
	@RequestMapping("/toOrderUpdate") 
	public String toOrderUpdate(Model model , Integer id ) {
		
		List<Door> doorList = orderService.findAllDoor();
		model.addAttribute("doorList", doorList) ; 
		
		Order order = orderService.getOrderById(id); 
		model.addAttribute("order", order);
		
		
		return "forward:/order_update" ; 
	}
	
	/**
	 * 修改 订单信息
	 * @return
	 */
	@RequestMapping("orderUpdate")
	public String OrderUpdate(Order order ) {
		
		orderService.orderUpdate(order) ; 
		
		return "forward:/order_list" ; 
	}
	
}
