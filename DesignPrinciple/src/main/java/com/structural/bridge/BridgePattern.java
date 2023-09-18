package com.structural.bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

interface Renderer {
	public void renderShape(double... dims) throws Exception;
}

class CircleRenderer implements Renderer {
	@Override
	public void renderShape(double... radius) throws Exception {
		if (radius != null && radius.length > 0) {
			System.out.println("Circle Drawn for radius [" + radius[0] + "]");
		} else {
			throw new Exception("Radius cannot be Empty");
		}
	}
}

class RectangleRenderer implements Renderer {
	@Override
	public void renderShape(double... dimension) throws Exception {
		if (dimension != null && dimension.length > 0 && dimension.length <= 2) {
			System.out.println("Rectanle Drawn for Length [" + dimension[0] + "] Breadth [" + dimension[1] + "]");
		} else {
			throw new Exception("Rectangle Length and Breath cannot be Empty");
		}
	}
}

abstract class Shape {

	private Renderer renderer = null;

	public Shape(Renderer renderer) {
		super();
		this.setRenderer(renderer);
	}

	protected abstract void draw();

	protected abstract void resize(double... arg);

	protected Renderer getRenderer() {
		return renderer;
	}

	protected void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

}

class Circle extends Shape {
	private double radius = 3;
	private Renderer renderer;

	@Inject
	public Circle(Renderer renderer) {
		super(renderer);
		this.renderer = renderer;
	}

	public Circle(Renderer renderer, double radius) {
		super(renderer);
		this.renderer = renderer;
		this.setRadius(radius);
	}

	@Override
	public void draw() {
		try {
			renderer.renderShape(radius);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resize(double... radius) {
		if (radius != null && radius.length > 0) {
			this.setRadius(this.getRadius() + radius[0]);
		}
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}

class Rectangle extends Shape {
	private double length = 4;
	private double breath = 4;
	private Renderer renderer;

	@Inject
	public Rectangle(Renderer renderer) {
		super(renderer);
		this.renderer = renderer;
		this.setLength(length);
		this.setBreath(breath);
	}

	public Rectangle(Renderer renderer, double length, double breath) {
		super(renderer);
		this.setLength(length);
		this.setBreath(breath);
	}

	@Override
	public void draw() {
		try {
			renderer.renderShape(length, breath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resize(double... dimension) {
		if (dimension != null && dimension.length > 0 && dimension.length <= 2) {
			setLength(getLength() + dimension[0]);
			setBreath(getBreath() + dimension[1]);
		}
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getBreath() {
		return breath;
	}

	public void setBreath(double breath) {
		this.breath = breath;
	}
}

class ShapeModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Renderer.class).to(RectangleRenderer.class);
	}
}

/*
	Bridge Pattern is used to decouple the abstraction from its implementation so that each can develop independently and achieve Loose Coupling. example Spring Dependency Injection
*/
public class BridgePattern {
	public static void main(String args[]) {
		Injector injector = Guice.createInjector(new ShapeModule());
		Shape shape = injector.getInstance(Rectangle.class);
		shape.draw();
		 /*
		 * Shape shape = new Circle(new CircleRenderer(),8); shape.draw();
		 * shape.resize(2); shape.draw();
		 */

	}
}
