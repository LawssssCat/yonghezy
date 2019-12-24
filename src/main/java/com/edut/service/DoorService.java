package com.edut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edut.dao.DoorMapper;
import com.edut.pojo.Door;

@Service
public class DoorService {
	/**
	 * 自动装配：可以为当前变量赋值：到spring容器中根据类型匹配
	 * DoorMapper 接口子类实例
	 * 
	 * <property name="mapperLocations" value="classpath:mybatis/mapper/*.xml" />
	 * 
	 * mapper/*.xml ==> 指定的 XxxMapper.java 接口 ==> 里面有 DoorMapper
	 */
	@Autowired
	private DoorMapper doorDao ; 
	
	
	public List<Door> testssm() {
		//查询所有门店信息
		List<Door> list = doorDao.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
		return list ; 
	}
	

	public List<Door> getDoorList(Model model) {
		List<Door> doorList = doorDao.findAll();
		model.addAttribute("doorList", doorList) ; 
		return doorList;
	}
	
	
	/**
	 * 添加 Door 
	 */
	public void addDoor(Door door) {
		doorDao.insert(door);
	}
	
	/**
	 * 根据 id 删除门店信息 
	 */
	@RequestMapping("/doorDelete")
	public void doorDelete(Door door , Model model ) {
		try {
			doorDao.delete(door);
		}catch (DataIntegrityViolationException ex) {
			String msg = "删除失败：外键相关" ;
			model.addAttribute("deleteException" , msg) ; 
		}
	}
	
	/**
	 * 查询 door 信息
	 * 转跳发 更新页面
	 */
	public void getDoorInfoById(Door door , Model model ) {
		door = doorDao.findById(door.getId());
		model.addAttribute("door", door) ; 
	}
	
	public void doorUpdate(Door door ) {
		doorDao.update(door);
	}
	
	
}
