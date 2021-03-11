package com.winchampion.credit.pure.mapper;

import org.apache.ibatis.annotations.Param;

import com.winchampion.credit.pure.entity.Blog;

public interface BlogMapper {
	Blog selectBlog(@Param("id") Integer id);
}
