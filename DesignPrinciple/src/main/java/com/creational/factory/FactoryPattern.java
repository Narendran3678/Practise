package com.creational.factory;
class Point {
	private double x;
	private double y;
	private String productType;

	private Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public static class PointFactory
	{
		public static Point getCartesionProduct(double x, double y) {
			Point point = new Point(x, y);
			point.setProductType("Cartesion Product");
			return point;
		}

		public static Point getPolarProduct(double rho, double theta) {

			Point point = new Point(rho * Math.cos(theta), rho * Math.sin(theta));
			point.setProductType("Polar Product");
			return point;
		}
	}
	

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}

	public String getProductType() {
		return productType;
	}

	private void setProductType(String productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", productType=" + productType + "]";
	}

}

public class FactoryPattern {
	public static void main(String args[]) {
		Point cartPoint = Point.PointFactory.getCartesionProduct(2, 3);
		Point poloarPoint = Point.PointFactory.getPolarProduct(2, 3);
		
		System.out.println(cartPoint);
		System.out.println(poloarPoint);
	}
}
