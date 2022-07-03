package com.ducat.springboot.rest.model;

import java.util.List;

public class EligibilityRequest {

	private List<Account> accountList;

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
}
