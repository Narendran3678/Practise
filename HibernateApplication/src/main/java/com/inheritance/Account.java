package com.inheritance;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass //To Not Persist Parent Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Column(name="account_number")
	private String accoutNumber;
	
	@Column(name="account_owner")
	private String accountOwner;

	public Account()
	{
		
	}
		
	public Account(String accoutNumber, String accountOwner) {
		super();
		this.accoutNumber = accoutNumber;
		this.accountOwner = accountOwner;
	}

	public Long getId() {
		return id;
	}

	public String getAccoutNumber() {
		return accoutNumber;
	}

	public void setAccoutNumber(String accoutNumber) {
		this.accoutNumber = accoutNumber;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accoutNumber=" + accoutNumber + ", accountOwner=" + accountOwner + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountOwner, accoutNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountOwner, other.accountOwner) && Objects.equals(accoutNumber, other.accoutNumber);
	}
	
}
