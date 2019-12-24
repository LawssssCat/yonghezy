package com.edut.dao;

import java.util.List;

import com.edut.pojo.Door;

public interface DoorMapper {
	
	public List<Door> findAll() ;
	
	public void insert(Door door);
	
	public void delete(Door door);
	
	public void update(Door door);

	public Door findById(Integer id);
}
