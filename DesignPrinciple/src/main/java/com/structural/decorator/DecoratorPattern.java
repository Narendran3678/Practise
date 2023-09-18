package com.structural.decorator;

import java.util.*;

interface Pizza
{
	public List<String> getIngredients();
	public int pizzaCost();
}
class PlainPizza implements Pizza
{
	private int cost =100;
	private PizzaDecorator toppins;
	public PlainPizza(PizzaDecorator toppins){
		this.toppins=toppins;
	}
	public PlainPizza(){
		
	}
	@Override
	public List<String> getIngredients() {
		List<String> ingredient = new ArrayList<>();
		ingredient.add("Dough");
		ingredient.add("Cheese");
		
		if(toppins != null && (toppins.getIngredients()!= null && toppins.getIngredients().size()>0))
			ingredient.addAll(toppins.getIngredients());
		
		return ingredient;
	}

	@Override
	public int pizzaCost() {
		int overallCost = cost;
		if(toppins!=null && toppins.pizzaCost()>0)
			overallCost+=toppins.pizzaCost();
		return overallCost;
	}
	@Override
	public String toString() {
		return "Pizza [cost=" + cost + ", toppins=" + toppins + "]";
	}
}

abstract class PizzaDecorator
{
	public abstract List<String> getIngredients();
	public abstract int pizzaCost();
}
class TomatoSause extends PizzaDecorator
{
	private PizzaDecorator toppins;
	public TomatoSause(PizzaDecorator toppins){
		this.toppins=toppins;
	}
	public TomatoSause(){
	
	}
	@Override
	public List<String> getIngredients() {
		List<String> ingredient = new ArrayList<>();
		ingredient.add("Tomato Sauce");
		
		if(toppins != null && (toppins.getIngredients()!= null && toppins.getIngredients().size()>0))
			ingredient.addAll(toppins.getIngredients());
		return ingredient;
	}

	@Override
	public int pizzaCost() {
		int overallCost = 20;
		if(toppins!=null && toppins.pizzaCost()>0)
			overallCost+=toppins.pizzaCost();
		return overallCost;
	}
}
class Olive extends PizzaDecorator
{
	private PizzaDecorator toppins;
	public Olive(PizzaDecorator toppins){
		this.toppins=toppins;
	}
	public Olive(){
	}
	@Override
	public List<String> getIngredients() {
		List<String> ingredient = new ArrayList<>();
		ingredient.add("Olives");
		if(toppins != null && (toppins.getIngredients()!= null && toppins.getIngredients().size()>0))
			ingredient.addAll(toppins.getIngredients());
		return ingredient;
	}

	@Override
	public int pizzaCost() {
		int overallCost = 10;
		if(toppins!=null && toppins.pizzaCost()>0)
			overallCost+=toppins.pizzaCost();
		return overallCost;
	}
	
}
class Cheese extends PizzaDecorator
{

	private PizzaDecorator toppins;
	public Cheese(PizzaDecorator toppins){
		this.toppins=toppins;
	}
	public Cheese(){
	}
	@Override
	public List<String> getIngredients() {
		List<String> ingredient = new ArrayList<>();
		ingredient.add("Cheese");
		if(toppins != null && (toppins.getIngredients()!= null && toppins.getIngredients().size()>0))
			ingredient.addAll(toppins.getIngredients());
		return ingredient;
	}

	@Override
	public int pizzaCost() {
		int overallCost = 30;
		if(toppins!=null && toppins.pizzaCost()>0)
			overallCost+=toppins.pizzaCost();
		return overallCost;
	}
	
}
/*
 1. Decorator Pattern allows you to modify object dynamically.
 2. If you want have a capabilities of inheritance and also need to add functionality without rewriting the old code.
 */
public class DecoratorPattern {
	
	
	public static void main(String args[]) {
		Pizza pizza = new PlainPizza(new TomatoSause(new Cheese(new Olive())));
		System.out.println(pizza.getIngredients()+"-"+pizza.pizzaCost());
	}
}
