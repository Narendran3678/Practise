package com.entity;

public enum Salutation {
	
	MR(101),
	MISS(102),
	MRS(103);
	
	int salutationValue = 0;
	Salutation(int salutationValue){
		this.salutationValue=salutationValue;
	}
	public int getSalutationValue() {
		return salutationValue;
	}
}
