package com.nt.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="INH_CHEQUE_PAYMENT2")
@PrimaryKeyJoinColumn(name="tx_id",referencedColumnName="txId")
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
