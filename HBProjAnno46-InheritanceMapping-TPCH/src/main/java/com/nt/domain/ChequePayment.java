package com.nt.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment {
	private int  chequeNo;
	private String chequeType;
	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	@Override
	public String toString() {
		return "ChequePayment "+super.toString()+"chequeNo=" + chequeNo + ", chequeType=" + chequeType + "]";
	}

	
}
