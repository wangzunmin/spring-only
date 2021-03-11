package com.winchampion.credit.pure.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.winchampion.credit.pure.transaction.entity.User2;
import com.winchampion.credit.pure.transaction.mapper.User2Mapper;

@Service
public class User2Service {
	

	@Autowired
	private User2Mapper user2Mapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(User2 record){
		user2Mapper.insert(record);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertException(User2 record){
		 user2Mapper.insert(record);
		 throw new RuntimeException();
	} 
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert_require_new(User2 record){
		user2Mapper.insert(record);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert_require_new_exception(User2 record){
		user2Mapper.insert(record);
		throw new RuntimeException();
	}
	
	
	public void select() {
		List<User2> list = user2Mapper.queryUser2();
		System.out.println(list.size());
	}
	
}
