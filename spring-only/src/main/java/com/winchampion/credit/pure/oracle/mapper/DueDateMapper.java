package com.winchampion.credit.pure.oracle.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.winchampion.credit.pure.oracle.entity.DueDate;

@Repository
public interface DueDateMapper {
	int count();
	List<DueDate> queryAll();
}
