package com.composityandcollection;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WarehouseCK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="warehouse_name")
	private String warehouseName;

	@Column(name="building_name")
	private String buildingName;
	
	public WarehouseCK(){
	}
	
	public WarehouseCK(String warehouseName, String buildingName) {
		super();
		this.warehouseName = warehouseName;
		this.buildingName = buildingName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildingName, warehouseName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WarehouseCK other = (WarehouseCK) obj;
		return Objects.equals(buildingName, other.buildingName) && Objects.equals(warehouseName, other.warehouseName);
	}

	@Override
	public String toString() {
		return "WarehouseCK [warehouseName=" + warehouseName + ", buildingName=" + buildingName + "]";
	}
}
