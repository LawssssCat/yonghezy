package com.edut.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.edut.dao.DoorMapper;
import com.edut.pojo.Door;

public class TestMybatis {
	
	private SqlSession session  ; 
	DoorMapper doorMapperDao  ; 
	{
		try {
			//默认classpath（spring才有）
			InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
			
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in); 
			
			session = build.openSession() ; 
			doorMapperDao = session.getMapper(DoorMapper.class);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	@Test
	public void testFindAll() {
		List<Door> doors = doorMapperDao.findAll();
		for (Door door : doors) {
			System.out.println(door);
		}
	}
}
