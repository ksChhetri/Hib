package com.nt.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="INH_CASH_PAYMENT2")
@PrimaryKeyJoinColumn(name="tx_id",referencedColumnName="txId")
public class CashPayment extends Payment {
	private String denominations;

	public String getDenominations() {
		return denominations;
	}

	public void setDenominations(String denominations) {
		this.denominations = denominations;
	}

	@Override
	public String toString() {
		return "CashPayment "+super.toString()+" denominations=" + denominations + "]";
	}
	
	

}
