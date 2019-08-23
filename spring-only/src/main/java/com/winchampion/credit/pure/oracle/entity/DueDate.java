package com.winchampion.credit.pure.oracle.entity;

public class DueDate {
	private String tradeDate;//交易日
    private String ternorName;//交易类型（1-即期；2-远期 3-掉期）
    private String dueDate;//到期日
    private String dueDateType;//到期日类型（s-标准，f-非标准）
    private String ternorType;
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getTernorName() {
		return ternorName;
	}
	public void setTernorName(String ternorName) {
		this.ternorName = ternorName;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDueDateType() {
		return dueDateType;
	}
	public void setDueDateType(String dueDateType) {
		this.dueDateType = dueDateType;
	}
	public String getTernorType() {
		return ternorType;
	}
	public void setTernorType(String ternorType) {
		this.ternorType = ternorType;
	}
	@Override
	public String toString() {
		return "DueDate [tradeDate=" + tradeDate + ", dueDate=" + dueDate + "]";
	}
    
	
	
    
    

}
