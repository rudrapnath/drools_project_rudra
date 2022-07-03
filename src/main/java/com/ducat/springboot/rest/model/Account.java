package com.ducat.springboot.rest.model;

public class Account {
	public String accountNumber;
	public String accountType;
	public String custId;
	public String productCode;
	public boolean eligibilityCheck;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public boolean isEligibilityCheck() {
		return eligibilityCheck;
	}
	public void setEligibilityCheck(boolean eligibilityCheck) {
		this.eligibilityCheck = eligibilityCheck;
	}
	
	
}
