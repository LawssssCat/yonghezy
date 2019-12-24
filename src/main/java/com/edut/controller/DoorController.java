package com.edut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edut.dao.DoorMapper;
import com.edut.pojo.Door;
import com.edut.service.DoorService;

/**@Controller 注解的作用：
 * 1. 标识当前类属于 Controller 层
 * 2. 标记当前类对象的创建将交给 spring 容器负责
 */
@Controller("doorController")
public class DoorController {
	
	@Autowired
	private DoorService doorService ; 
	
	/**测试 SpringMVC 的开发环境
	 * */
	//@RequestMapping("/test")
	public String test() {
		return "test";
	}

	
	/*
	 * 通用的 页面跳转方法
	 * ------------
	 * /index
	 * /_top
	 * /door_list
	 * ------------
	 * 如果访问的路径为 "/index" 那么{}里面的 page值为 "index"
	 * 再将{}中的page的值传递给方法上的形参page，此时形参page的值也为"index" , 
	 * 再将 page 的值作为返回值返回。
	 * 
	 * 因此，以后如果想访问 WEB-INF/pages目录下的jsp文件，
	 * 只需要在访问时，访问路径为 "/jsp的名字" 就可以访问到指定的名字的jsp!!
	 */
	@RequestMapping("/{page}")
	public String toPage(@PathVariable String page) {
		return page ; 
	}
	
	
	/**
	 * 测试ssm的开发环境
	 */
	//@RequestMapping("/testssm")
	public String testssm() {
		doorService.testssm() ;
		return "test";
	}
	
	@RequestMapping("doorList")
	public String toDoorList(Model model) {
		doorService.getDoorList(model); 
		return "door_list";
	}
	
	/**
	 * 添加 Door 
	 */
	@RequestMapping("/doorAdd")
	public String addDoor(Door door) {
		doorService.addDoor(door);
		return "forward:doorList" ; 
	}
	
	/**
	 * 根据 id 删除门店信息 
	 */
	@RequestMapping("/doorDelete")
	public String doorDelete(Door door , Model model ) {
		doorService.doorDelete(door , model );
		return "forward:doorList" ; 
	}
	
	/**
	 * 查询 door 信息
	 * 转跳发 更新页面
	 */
	@RequestMapping("/doorInfo")
	public String doorInfo(Door door , Model model ) {
		doorService.getDoorInfoById(door, model );
		return "door_update" ;
	}
	
	
	@RequestMapping("doorUpdate")
	public String doorUpdate(Door door ) {
		doorService.doorUpdate(door);
		return "forward:doorList" ; 
	}
	
}
