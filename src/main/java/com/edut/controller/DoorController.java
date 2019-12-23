package com.edut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**@Controller 注解的作用：
 * 1. 标识当前类属于 Controller 层
 * 2. 标记当前类对象的创建将交给 spring 容器负责
 */
@Controller
public class DoorController {
	
	/**测试 SpringMVC 的开发环境
	 * */
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
