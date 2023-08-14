package com.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="credit_card")
public class CreditCard extends Account {
	
	@Column(name="card_type")
	private String card_type;
	
	@Column(name="credit_used")
	private String credit_used;
	
	@Column(name="credit_limit")
	private String credit_limit;

	public CreditCard()
	{
		
	}
	
	public CreditCard(String card_type, String credit_limit) {
		super();
		this.card_type = card_type;
		this.credit_limit = credit_limit;
	}

	public CreditCard(String card_type, String credit_used, String credit_limit) {
		super();
		this.card_type = card_type;
		this.credit_used = credit_used;
		this.credit_limit = credit_limit;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(String credit_limit) {
		this.credit_limit = credit_limit;
	}
	
	public String getCredit_used() {
		return credit_used;
	}

	public void setCredit_used(String credit_used) {
		this.credit_used = credit_used;
	}

	@Override
	public String toString() {
		return "CreditCard [card_type=" + card_type + ", credit_used=" + credit_used + ", credit_limit=" + credit_limit
				+ "]";
	}

}
