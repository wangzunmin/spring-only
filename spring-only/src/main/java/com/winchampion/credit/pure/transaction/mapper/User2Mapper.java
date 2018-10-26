package com.winchampion.credit.pure.transaction.mapper;

import org.springframework.stereotype.Repository;

import com.winchampion.credit.pure.transaction.entity.User2;
@Repository
public interface User2Mapper {
	int insert(User2 record);

	User2 selectByPrimaryKey(Integer id);
}
