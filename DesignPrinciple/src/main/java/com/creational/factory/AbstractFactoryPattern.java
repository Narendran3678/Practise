 package com.creational.factory;

class VehicleType
{
	public static final String MERCEDEZ_CAR = "MERCEDEZ_CAR";
	public static final String AUDI_CAR = "AUDI_CAR";
	
	public static final String SUZUKI_BIKE= "SUZUKI_BIKE";
	public static final String BMW_BIKE= "BMW_BIKE";
}
interface VehicleFactory {
	public Vehicle manufactureVehicle(String vechicleType);
}

abstract class Vehicle {
	
	int vehicleTire;
	String vehicleName;
	String engineCC;
	String mileage;
	double price;
	
	public int getVehicleTire() {
		return vehicleTire;
	}
	public void setVehicleTire(int vehicleTire) {
		this.vehicleTire = vehicleTire;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getEngineCC() {
		return engineCC;
	}
	public void setEngineCC(String engineCC) {
		this.engineCC = engineCC;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleTire=" + vehicleTire + ", vehicleName=" + vehicleName + ", engineCC=" + engineCC
				+ ", mileage=" + mileage + ", price=" + price + "]";
	}	
	
}

class MercedezCar extends Vehicle {

	private MercedezCar(int vehicleTire, String engineCC, String mileage, double price) {
		super();
		this.vehicleTire = vehicleTire;
		this.vehicleName = "MERCEDEZ";
		this.engineCC = engineCC;
		this.mileage = mileage;
		this.price = price;
	}

	public static class MercedezCarFactory extends CarFactory {
		public static MercedezCar getMercedezCar()
		{
			MercedezCar mCar = new MercedezCar(4,"300cc","12KMPH",50_00_000);
			return mCar ;
		}
	}
}
class AudiCar extends Vehicle {
	private AudiCar(int vehicleTire, String engineCC, String mileage, double price) {
		super();
		this.vehicleTire = vehicleTire;
		this.vehicleName = "AUDI";
		this.engineCC = engineCC;
		this.mileage = mileage;
		this.price = price;
	}
	public static class AudiCarFactory extends CarFactory {
		public static AudiCar getAudiCar()
		{
			AudiCar mCar = new AudiCar(4,"340cc","18KMPH",75_00_000);
			return mCar ;
		}
	}
}

class BMWBike extends Vehicle {
	private BMWBike(int vehicleTire, String engineCC, String mileage, double price) {
		super();
		this.vehicleTire = vehicleTire;
		this.vehicleName = "BMW";
		this.engineCC = engineCC;
		this.mileage = mileage;
		this.price = price;
	}
	public static class BMWBikeFactory extends BikeFactory {
		public static BMWBike getBMWBike()
		{
			BMWBike bBike = new BMWBike(2,"400cc","22KMPH",35_00_000);
			return bBike ;
		}
	}
}

class SuzukiBike extends Vehicle {
	private SuzukiBike(int vehicleTire, String engineCC, String mileage, double price) {
		super();
		this.vehicleTire = vehicleTire;
		this.vehicleName = "SUZUKI";
		this.engineCC = engineCC;
		this.mileage = mileage;
		this.price = price;
	}
	public static class SuzukiBikeFactory extends BikeFactory {
		public static SuzukiBike getSuzukiBike()
		{
			SuzukiBike bBike = new SuzukiBike(2,"350cc","20KMPH",25_00_000);
			return bBike ;
		}
	}
}
class BikeFactory implements VehicleFactory {
	@Override
	public Vehicle manufactureVehicle(String bikeType) {
		Vehicle vehicle =null;
		switch(bikeType)
		{
			case VehicleType.BMW_BIKE:
				vehicle =  BMWBike.BMWBikeFactory.getBMWBike();
				break;
			
			case VehicleType.SUZUKI_BIKE:
				vehicle =  SuzukiBike.SuzukiBikeFactory.getSuzukiBike();
				break;
			
			default:
				System.out.println("Vehicle Not Found ["+bikeType+"]");
		}
		return vehicle;
	}
}

class CarFactory implements VehicleFactory {
	@Override
	public Vehicle manufactureVehicle(String carType) {
		Vehicle vehicle =null;
		switch(carType)
		{
			case VehicleType.MERCEDEZ_CAR:
				vehicle =  MercedezCar.MercedezCarFactory.getMercedezCar();
				break;
			
			case VehicleType.AUDI_CAR:
				vehicle =  AudiCar.AudiCarFactory.getAudiCar();
				break;
			
			default:
				System.out.println("Vehicle Not Found ["+carType+"]");	
		}
		return vehicle;
	}
}


public class AbstractFactoryPattern {
	public static void main(String args[]) {
		Vehicle vehicle = new CarFactory().manufactureVehicle(VehicleType.MERCEDEZ_CAR);
		System.out.println(vehicle);
		
		vehicle = new BikeFactory().manufactureVehicle(VehicleType.BMW_BIKE);
		System.out.println(vehicle);
	}
}
