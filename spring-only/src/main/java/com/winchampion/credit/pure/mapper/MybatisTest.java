package com.winchampion.credit.pure.mapper;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.winchampion.credit.pure.entity.Blog;

public class MybatisTest {

	public static void main(String[] args) throws IOException {
		String resource = "com/winchampion/credit/pure/mapper/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//包含对mybatis全局配置文件的
		SqlSession sqlSession = sqlSessionFactory.openSession();//包含实例化Executor对象
		BlogMapper mapper = sqlSession.getMapper(BlogMapper.class); //生成org.apache.ibatis.binding.MapperProxy代理
		Blog blog = mapper.selectBlog(1);//这里真实的调用是代理对象MapperProxy的方法，包含生成StatementHandler、ParameterHandler、ResultSetHandler
		System.out.println(blog);
	}
}
