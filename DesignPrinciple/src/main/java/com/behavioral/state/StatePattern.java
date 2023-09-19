package com.behavioral.state;

import java.util.concurrent.ThreadLocalRandom;

abstract class OrderState {
	public abstract void processState(OrderContext orderContext);
}

class OrderEntry extends OrderState {
	private int orderId=0;
	private String orderName = null;
	boolean isOrderPlace=false;
	public OrderEntry( String orderName) {
		this.orderName=orderName;
	}
	@Override
	public void processState(OrderContext orderContext) {
		System.out.println("Order Placed");
		orderId= ThreadLocalRandom.current().nextInt();
		isOrderPlace = true;
		orderContext.setOrderState(new OrderPacking(this,"Box Type"));
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public boolean isOrderPlace() {
		return isOrderPlace;
	}
	public void setOrderPlace(boolean isOrderPlace) {
		this.isOrderPlace = isOrderPlace;
	}
	@Override
	public String toString() {
		return "orderId=" + orderId + ", orderName=" + orderName + ", isOrderPlace=" + isOrderPlace ;
	}
}

class OrderPacking extends OrderState {
	private OrderEntry orderEntry;
	private String packageType;
	boolean isOrderPacked=false;
	public OrderPacking(OrderEntry orderEntry,String packageType)
	{
		this.orderEntry =orderEntry;
		this.packageType=packageType;
	}
	@Override
	public void processState(OrderContext orderContext) {
		System.out.println("Order Packed");
		isOrderPacked = true;
		orderContext.setOrderState(new OrderShipping(this,"India"));
	}
	public OrderEntry getOrderEntry() {
		return orderEntry;
	}
	public void setOrderEntry(OrderEntry orderEntry) {
		this.orderEntry = orderEntry;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public boolean isOrderPacked() {
		return isOrderPacked;
	}
	public void setOrderPacked(boolean isOrderPacked) {
		this.isOrderPacked = isOrderPacked;
	}
	@Override
	public String toString() {
		return  orderEntry + ", packageType=" + packageType + ", isOrderPacked="+ isOrderPacked ;
	}
	
}
class OrderShipping extends OrderState {
	private OrderPacking orderPacking;
	private String shipLocation;
	boolean isOrderShipped=false;
	public OrderShipping(OrderPacking orderPacking,String shipLocation)
	{
		this.orderPacking=orderPacking;
		this.shipLocation=shipLocation;
	}

	public OrderPacking getOrderPacking() {
		return orderPacking;
	}

	public void setOrderPacking(OrderPacking orderPacking) {
		this.orderPacking = orderPacking;
	}

	public String getShipLocation() {
		return shipLocation;
	}

	public void setShipLocation(String shipLocation) {
		this.shipLocation = shipLocation;
	}

	@Override
	public void processState(OrderContext orderContext) {
		System.out.println("Order Shipped");
		isOrderShipped = true;
		orderContext = null;
	}

	@Override
	public String toString() {
		return orderPacking + ", shipLocation=" + shipLocation + ", isOrderShipped="+isOrderShipped;
	}

	
}
class OrderContext {
	private OrderState orderState = null;
	public OrderContext(String orderName)
	{
		if(orderState==null)
		{
			orderState = new OrderEntry(orderName);
		}
	}
	public void processState(OrderContext orderContext) {
		orderState.processState(orderContext);
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}
	
}
/*
 * This pattern allows object to change it state when its internal state changes . Its has 3 parts
 * 1. Context : Which hold the current instantiated concrete class.
 * 2. State : Hold encapsulating behavior which need to be implemented in subclass
 * 3. Concrete State : Implements the behavior of state 
 */
public class StatePattern {
	public static void main(String args[])
	{
		OrderContext state= new OrderContext("Java Book");
		state.processState(state); // Order Entry
		state.processState(state); // Order Packed
		state.processState(state); // Order Shipped
		
		System.out.println(state.getOrderState());
	}
}
