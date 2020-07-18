package com.mphasis.training.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "SA")
@PrimaryKeyJoinColumn(name = "accnum")
public class SavingsAccount extends Account{
	
	private long adarNum;

	public long getAdarNum() {
		return adarNum;
	}

	public void setAdarNum(long adarNum) {
		this.adarNum = adarNum;
	}
	
	
}
