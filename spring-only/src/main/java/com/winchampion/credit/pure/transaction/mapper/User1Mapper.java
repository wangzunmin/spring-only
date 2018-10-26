package com.winchampion.credit.pure.transaction.mapper;

import org.springframework.stereotype.Repository;

import com.winchampion.credit.pure.transaction.entity.User1;

@Repository
public interface User1Mapper {
	int insert(User1 record);

//	User1 selectByPrimaryKey(Integer id);
}
