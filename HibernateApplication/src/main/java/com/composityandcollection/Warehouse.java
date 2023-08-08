package com.composityandcollection;

import java.util.*;
import com.entity.DAOI;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="warehouse")
public class Warehouse extends DAOI{
	
	@EmbeddedId
	private WarehouseCK warehouseCK;
	
	@Column(name="warehouse_owner")
	private String warehouseOwner;

	@Column(name="warehouse_dimension")
	private String warehouseDimension;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "warehouse")
	private List<Customer> customerList = new ArrayList<>();
	
	public Warehouse()
	{
		
	}
	
	public Warehouse(String warehouseName, String buildingName,String warehouseOwner, String warehouseDimension)
	{
		warehouseCK = new WarehouseCK(warehouseName,buildingName);
		this.warehouseOwner =warehouseOwner;
		this.warehouseDimension = warehouseDimension;
	}
	
	public Warehouse(WarehouseCK warehouseCK, String warehouseOwner, String warehouseDimension) {
		super();
		this.warehouseCK = warehouseCK;
		this.warehouseOwner = warehouseOwner;
		this.warehouseDimension = warehouseDimension;
	}

	public WarehouseCK getWarehouseCK() {
		return warehouseCK;
	}
	public void setWarehouseCK(WarehouseCK warehouseCK) {
		this.warehouseCK = warehouseCK;
	}
	public String getWarehouseOwner() {
		return warehouseOwner;
	}
	public void setWarehouseOwner(String warehouseOwner) {
		this.warehouseOwner = warehouseOwner;
	}
	public String getWarehouseDimension() {
		return warehouseDimension;
	}
	public void setWarehouseDimension(String warehouseDimension) {
		this.warehouseDimension = warehouseDimension;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public String toString() {
		return "Warehouse [warehouseCK=" + warehouseCK + ", warehouseOwner=" + warehouseOwner + ", warehouseDimension="
				+ warehouseDimension + ", customerList=" + customerList + "]";
	}
	
	
}
