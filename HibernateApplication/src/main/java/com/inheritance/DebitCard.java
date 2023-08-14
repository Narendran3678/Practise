package com.inheritance;

import jakarta.persistence.*;

@Entity
@Table(name="debit_card")
public class DebitCard extends Account {
	
	@Column(name="card_type")
	private String cardType;
	
	@Column(name="account_balance")
	private String accountBalance;
	
	@Column(name="wifi_enabled")
	private Boolean wifiEnabled;

	public DebitCard()
	{
		
	}

	public DebitCard(String cardType, String accountBalance, Boolean wifiEnabled) {
		super();
		this.cardType = cardType;
		this.accountBalance = accountBalance;
		this.wifiEnabled = wifiEnabled;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Boolean getWifiEnabled() {
		return wifiEnabled;
	}

	public void setWifiEnabled(Boolean wifiEnabled) {
		this.wifiEnabled = wifiEnabled;
	}

	@Override
	public String toString() {
		return "DebitCard [cardType=" + cardType + ", accountBalance=" + accountBalance + ", wifiEnabled=" + wifiEnabled
				+ "]";
	}
	
	
}
