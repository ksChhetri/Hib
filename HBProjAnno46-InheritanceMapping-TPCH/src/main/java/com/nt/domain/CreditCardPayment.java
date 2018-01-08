package com.nt.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREDIT")
public class CreditCardPayment extends Payment {
	
	
	private long  cardNo;
	private String ccType;
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCcType() {
		return ccType;
	}
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	@Override
	public String toString() {
		return "CreditCardPayment--->"+super.toString()+"cardNo=" + cardNo + ", ccType=" + ccType + "]";
	}

}
