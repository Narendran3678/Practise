package com.behavioral.template;

abstract class BuildingTemplate
{
	protected abstract void buildWalls();
	protected abstract void buildRoof();
	protected abstract void buildrooms();
	
	public final void buildHouse() {
		buildWalls();
		buildRoof();
		buildrooms() ;
	}
}
class WoodenHouse extends BuildingTemplate
{
	@Override
	public void buildWalls() {
		System.out.println("Wooden Wall Build");		
	}
	@Override
	public void buildRoof() {
		System.out.println("Wooden Roof Build");
	}
	@Override
	public void buildrooms() {
		System.out.println("Wooden Room Build");
	}
}
class BrickHouse extends BuildingTemplate
{
	@Override
	public void buildWalls() {
		System.out.println("Brick Wall Build");		
	}
	@Override
	public void buildRoof() {
		System.out.println("Brick Roof Build");
	}
	@Override
	public void buildrooms() {
		System.out.println("Brick Room Build");
	}	
}
/*
 * Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass
 *  but lets subclasses override specific steps of the algorithm without changing its structure
 */
public class TemplatePattern {
	public static void main(String args[])
	{
		BuildingTemplate temp = new BrickHouse();
		temp.buildHouse();
	}
}
