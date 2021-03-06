package com.nt.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int txId;
	private int amount;
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "[txId=" + txId + ", amount=" + amount;
	}

}
