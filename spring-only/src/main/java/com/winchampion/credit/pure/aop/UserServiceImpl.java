package com.winchampion.credit.pure.aop;

public class UserServiceImpl implements UserService{
	/* (non-Javadoc) 
     * @see dynamic.proxy.UserService#add() 
     */  
    public void add() {  
        System.out.println("--------------------add---------------");  
    }  
}
