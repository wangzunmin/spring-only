package com.winchampion.credit.pure.mybatis.plugins;

import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 自定义mybatis插件 （这里可以理解责任链中的责任人角色）
 * 1.拦截器的拦截顺序  根据type的值
 * 2.拦截器多了会影响效率么
 * 3.
 * 
 * @author wangzunmin
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }), })
public class MybatisExamplePlugin implements Interceptor {

	private static final Integer MAPPED_STATEMENT_INDEX = 0;
	private static final Integer PARAMETER_INDEX = 1;
	private static final Integer ROW_BOUNDS_INDEX = 2;

	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		RowBounds rb = (RowBounds) args[ROW_BOUNDS_INDEX];

		args[ROW_BOUNDS_INDEX] = RowBounds.DEFAULT;

		MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT_INDEX];
		BoundSql boundSql = ms.getBoundSql(args[PARAMETER_INDEX]);

		// 获取 SQL 语句，替换sql语句
		//sql替换 如果出现替换了sql中不是预期的用户名 怎么解决 保证替换的位置
		String sql = boundSql.getSql();
		if(sql.contains("pprUser")) {
			sql = sql.replace("pprUser", "ppr_user");
		}

		// 创建一个 StaticSqlSource，并将拼接好的 sql 传入
		SqlSource sqlSource = new StaticSqlSource(ms.getConfiguration(), sql, boundSql.getParameterMappings());

		// 通过反射获取并设置 MappedStatement 的 sqlSource 字段
		Field field = MappedStatement.class.getDeclaredField("sqlSource");
		field.setAccessible(true);
		field.set(ms, sqlSource);

		// 执行被拦截方法
		return invocation.proceed();

	}

	public Object plugin(Object target) {
		 return Plugin.wrap(target, this);//生成代理对象 
	}

	public void setProperties(Properties properties) {

	}

}
