package com.hibernate;

import java.util.Arrays;

import com.composityandcollection.Customer;
import com.composityandcollection.Warehouse;
import com.composityandcollection.WarehouseDao;
import com.util.DAOUtil;

public class WarehouseClient {
	public static void main(String args[])
	{
		persistData();
	}
	public static void persistData()
	{
		DAOUtil warehouseUtil = new WarehouseDao();
		Warehouse warehouse = new Warehouse("WH1","B1","Jacob","122*122*122");
		Customer customer = new Customer("Frank","Federation Logistics");
		Customer customer1 = new Customer("Mike","Saddle Creek Logistics");
		customer.setWarehouse(warehouse);
		customer1.setWarehouse(warehouse);
		warehouse.setCustomerList(Arrays.asList(customer,customer1));
		warehouseUtil.hibernatePersistDAO(warehouse);
		warehouseUtil.hibernateCommitTransaction();
		warehouseUtil.hibernateCloseSession();
	}
}
