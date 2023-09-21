package com.behavioral.mediator;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Stock {
	private int userId = 0;
	private int stockPrice = 0;
	private String stockName = null;

	public Stock(int userId, int stockPrice, String stockName) {
		super();
		this.userId = userId;
		this.stockPrice = stockPrice;
		this.stockName = stockName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Override
	public String toString() {
		return "Stock [userId=" + userId + ", stockPrice=" + stockPrice + ", stockName=" + stockName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(stockName, stockPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(stockName, other.stockName) && stockPrice == other.stockPrice;
	}

}

abstract class Client {
	private Mediator mediator = null;
	private int clientId = 0;

	public Client(Mediator mediator) {
		this.mediator = mediator;
		mediator.addClients(this);
	}

	public void buyStocks(String stockName, int price) {
		mediator.buyStocks(stockName, price, this.clientId);
	}

	public void sellStocks(String stockName, int price) {
		mediator.sellStocks(stockName, price, this.clientId);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}

class Auro extends Client {

	public Auro(Mediator mediator) {
		super(mediator);
	}
}

class Maritime extends Client {

	public Maritime(Mediator mediator) {
		super(mediator);
	}
}

interface Mediator {
	public void buyStocks(String stockName, int stockPrice, int userId);

	public void sellStocks(String stockName, int stockPrice, int userId);

	public void addClients(Client client);

	public void stockInventory();
}

class ZerodhaMediator implements Mediator {
	private List<Stock> buyStocks;
	private List<Stock> saleStocks;
	private Set<Stock> stocksOwned;
	private Set<Client> clients;

	public ZerodhaMediator() {
		buyStocks = new ArrayList<>();
		saleStocks = new ArrayList<>();
		stocksOwned = new HashSet<>();
		clients = new HashSet<>();
	}

	@Override
	public void addClients(Client client) {
		client.setClientId(ThreadLocalRandom.current().nextInt());
		clients.add(client);
	}

	@Override
	public void buyStocks(String stockName, int stockPrice, int userId) {

		Optional<Stock> stockBought = saleStocks.stream().filter((s) -> {
			if (s.getStockPrice() == stockPrice && s.getStockName().equals(stockName)) {
				System.out.println("Stock " + stockName + " with price " + stockPrice + " sold to " + userId);
				// saleStocks.remove(s);
				Stock newStock = new Stock(userId, stockPrice, stockName);
				stocksOwned.add(newStock);
				return true;
			}
			return false;
		}).findFirst();
		if (!stockBought.isEmpty()) {
			// System.out.println("Sales Removed."+stockBought.get());
			saleStocks.remove(stockBought.get());
		} else {
			Stock newStock = new Stock(userId, stockPrice, stockName);
			buyStocks.add(newStock);
		}
	}

	@Override
	public void sellStocks(String stockName, int stockPrice, int userId) {
		Optional<Stock> stockSold = buyStocks.stream().filter((s) -> {
			if (s.getStockPrice() == stockPrice && s.getStockName().equals(stockName)) {
				System.out.println("Stock " + stockName + " with price " + stockPrice + " bought by " + userId);
				// Stock newStock = new Stock(userId,stockPrice,stockName);
				// stocksOwned.add(newStock);
				return true;
			}
			return false;
		}).findFirst();

		if (!stockSold.isEmpty()) {
			buyStocks.remove(stockSold.get());
		} else {
			Stock newStock = new Stock(userId, stockPrice, stockName);
			saleStocks.add(newStock);
		}
	}

	@Override
	public void stockInventory() {
		System.out.println();

		System.out.println("Stock Waiting to be Bought......");
		buyStocks.forEach(s -> {
			System.out.println(s);
		});
		
		System.out.println("Stock Waiting to be Sold......");
		saleStocks.forEach(s -> {
			System.out.println(s);
		});
		
		System.out.println("Owned Stock......");
		stocksOwned.forEach(s -> {
			
			System.out.println(s);

		});
	}
}

/*
 * Define an object that encapsulates how a set of objects interact. Mediator
 * promotes loose coupling by keeping objects from referring to each other
 * explicitly, and it lets you vary their interaction independently.
 */
public class MediatorDesignPattern {
	static Mediator mediator = new ZerodhaMediator();

	public static void main(String args[]) {

		Client auroClient = new Auro(mediator);
		Client maritimeClient = new Maritime(mediator);

		auroClient.sellStocks("NIFTY", 20);
		auroClient.sellStocks("BEE", 50);
		auroClient.sellStocks("ITBEE", 150);

		maritimeClient.buyStocks("NIFTY", 20);
		maritimeClient.buyStocks("BEE", 50);
		maritimeClient.sellStocks("BEE", 50);

		maritimeClient.buyStocks("ITBEE", 150);
		auroClient.buyStocks("BEE",50);
		
		mediator.stockInventory();

	}

}
