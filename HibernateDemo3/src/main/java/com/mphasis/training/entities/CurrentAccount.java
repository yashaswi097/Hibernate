package com.mphasis.training.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(name ="CA")
@PrimaryKeyJoinColumn(name = "accnum")
public class CurrentAccount extends Account{
	
	@Column(length = 10)
	private String gstin;

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	
}
