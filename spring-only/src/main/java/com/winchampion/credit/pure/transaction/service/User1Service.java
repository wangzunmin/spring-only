package com.winchampion.credit.pure.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.winchampion.credit.pure.transaction.entity.User1;
import com.winchampion.credit.pure.transaction.entity.User2;
import com.winchampion.credit.pure.transaction.mapper.User1Mapper;

@Service
public class User1Service {

	@Autowired
	private User1Mapper user1Mapper;
	
	@Autowired
	private User2Service user2Service;
	
	@Transactional(propagation = Propagation.REQUIRED)//如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
	public void insert(User1 record){
		 user1Mapper.insert(record);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)//新建事务，如果当前存在事务，把当前事务挂起。
	public void insert_require_new(User1 record){
		 user1Mapper.insert(record);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void testInsert(User1 record) {
		user1Mapper.insert(record);
		
		User2 record2 = new User2();
		record2.setName("tom");
//		user2Service.insert(record2);
		int a = 1/0;
	}
	
	
	
	
	
}
