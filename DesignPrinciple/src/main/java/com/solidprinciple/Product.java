package com.solidprinciple;
public class Product
{
	private String productName;
	private String size;
	private String color;
	public Product(String productName, String size, String color) {
		super();
		this.productName = productName;
		this.size = size;
		this.color = color;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", size=" + size + ", color=" + color + "]";
	}
}