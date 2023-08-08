package com.composityandcollection;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="warehouse_name"),
		@JoinColumn(name="building_name")
	})
	private Warehouse warehouse;

	public Customer()
	{
		
	}
	
	public Customer(String customerName, String companyName, Warehouse warehouse) {
		super();
		this.customerName = customerName;
		this.companyName = companyName;
		this.warehouse = warehouse;
	}

	public Customer(String customerName, String companyName) {
		super();
		this.customerName = customerName;
		this.companyName = companyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", companyName=" + companyName + "]";
	}
	
	
}
