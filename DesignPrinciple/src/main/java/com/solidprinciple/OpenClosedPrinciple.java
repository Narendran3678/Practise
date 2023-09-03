package com.solidprinciple;

import java.util.Arrays;
import java.util.List;

interface Specification<T> {
	boolean isSatisfied(T colorCondition);
}

interface Filter<T> {
	public List<T> filterBySpecs(List<T> productList, Specification<T> spec);
}

class ColorSpecification<T> implements Specification<T> {
	String color = "";
	public ColorSpecification(String color)
	{
		this.color=color;
	}
	@Override
	public boolean isSatisfied(T obj) {
		
		return color.equals(((Product)obj).getColor());
	}
}

class SizeSpecification<T> implements Specification<T> {
	String size = "";
	public SizeSpecification(String size)
	{
		this.size=size;
	}
	@Override
	public boolean isSatisfied(T obj) {
		return size.equals(((Product)obj).getSize());
	}
}

class ProductFilter<T> implements Filter<T> {

	@Override
	public List<T> filterBySpecs(List<T> productList, Specification<T> spec) {
		return productList.stream().filter(s -> spec.isSatisfied(s)).toList();
	}

}
/*
 *  Open Close Principle is when class open for extension close for Modification. Here Product Filter class no need of modification when 
 *  any new specification Based filter needed. If any new specification Like shelflife added simple a class need to implement Specification and 
 *  calling method should send the respective ShelfLifeSpecification
 */

public class OpenClosedPrinciple {
	public static void main(String args[]) {
		Product product1 = new Product("Apple","Round", "Red");
		Product product2 = new Product("Bat", "Irregular","Brown" );
		List<Product> productList = Arrays.asList(product1, product2);
		System.out.println("Open Close Principle");
		Filter<Product> filter = new ProductFilter<>();
		filter.filterBySpecs(productList,new ColorSpecification<Product>("Red")).forEach(System.out::println);
	}
}
