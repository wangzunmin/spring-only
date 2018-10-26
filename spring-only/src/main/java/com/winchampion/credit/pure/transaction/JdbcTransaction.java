package com.winchampion.credit.pure.transaction;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC事务代码
 * 		多个sql代码放在一块，保证其ACID特性
 * 局限性： 一个 JDBC 事务不能跨越多个数据库
 * @author WZM
 *
 * 2018年9月11日
 */
public class JdbcTransaction {
	public void JdbcTransfer() { 
	    java.sql.Connection conn = null;
	    Statement stmt= null;
	     try{ 
	        conn = conn =DriverManager.getConnection("jdbc:oracle:thin:@host:1521:SID","username","userpwd");
	         // 将自动提交设置为 false，
	         //若设置为 true 则数据库将会把每一次数据更新认定为一个事务并自动提交
	         conn.setAutoCommit(false);

	         stmt = conn.createStatement(); 
	         // 将 A 账户中的金额减少 500 
	         stmt.execute("update t_account set amount = amount - 500 where account_id = 'A'");
	         // 将 B 账户中的金额增加 500 
	         stmt.execute("update t_account set amount = amount + 500 where account_id = 'B'");

	         // 提交事务
	         conn.commit();
	         // 事务提交：转账的两步操作同时成功
	     } catch(SQLException sqle){            
	         try{ 
	             // 发生异常，回滚在本事务中的操做
	            conn.rollback();
	             // 事务回滚：转账的两步操作完全撤销
	             stmt.close(); 
	             conn.close(); 
	         }catch(Exception ignore){ 

	         } 
	         sqle.printStackTrace(); 
	     } 
	}
}
