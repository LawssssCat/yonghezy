package com.edut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edut.dao.DoorMapper;
import com.edut.pojo.Door;

/**@Controller 注解的作用：
 * 1. 标识当前类属于 Controller 层
 * 2. 标记当前类对象的创建将交给 spring 容器负责
 */
@Controller
public class DoorController {
	/**
	 * 自动装配：可以为当前变量赋值：到spring容器中根据类型匹配
	 * DoorMapper 接口子类实例
	 */
	@Autowired
	private DoorMapper doorMapperDao ; 
	
	
	/**测试 SpringMVC 的开发环境
	 * */
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	/**
	 * 测试ssm的开发环境
	 */
	@RequestMapping("/testssm")
	public String testssm() {
		//查询所有门店信息
		List<Door> list = doorMapperDao.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
		
		return "test" ; 
	}
	
	
	public String testAA() {
		return "" ; 
	}
}
