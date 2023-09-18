package com.structural.proxy;
enum COLOR
{
	RED("RED"),
	BLUE("BLUE"),
	GREEN("GREEN");
	private String type;
	COLOR(String type)
	{
		this.type=type;
	}
	public String type()
	{
		return type;
	}
}
interface ImageI {
	public void setBorder(int top,int right,int bottom,int left);

	public void setColor(String color);

	public void draw();
}

class ImageGenerator implements ImageI {
	
	private int top;
	private int right;
	private int bottom;
	private int left;
	private String color;
	
	public ImageGenerator(int top, int right, int bottom, int left, String color) {
		super();
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
		this.color = color;
	}
	
	@Override
	public void setBorder(int top,int right,int bottom,int left) {
		this.top=top;
		this.right=right;
		this.bottom=bottom;
		this.left=left;
	}

	@Override
	public void setColor(String color) {
		this.color=color;
	}

	@Override
	public void draw() {
		System.out.println("Image [top=" + top + ", right=" + right + ", bottom=" + bottom + ", left=" + left + ", color="
				+ color + "]");
	}

	
}

class ImageGeneratorProxy implements ImageI {

	public ImageGenerator imgGen;
	private int top;
	private int right;
	private int bottom;
	private int left;
	private String color;
	
	@Override
	public void setBorder(int top, int right, int bottom, int left) {
		
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}
	@Override
	public void setColor(String color) {
		this.color=color;
	}
	
	@Override
	public void draw() {
		if(!(top>0 && right>0 && bottom>0 && left >0))
		{
			System.out.println("Border not present");
			return;
		}
		COLOR col ;
		try {
			col = COLOR.valueOf(color);
		}
		catch(Exception e)
		{
			System.out.println(color+" Not Present");
			return;
		}
		switch(col)
		{
			case BLUE:
				break;
			case GREEN:
				break;
			case RED:
				break;
			default:
				System.out.println("Color not present");
				return;
		}
		if(imgGen==null) {
			imgGen = new ImageGenerator(top,right,bottom,left,color);
			imgGen.draw();
		}
		else {
			imgGen.draw();
		}
	}
}

public class VirtualProxy {
	public static void main(String args[]) {
		ImageI img = new ImageGeneratorProxy();
		img.setBorder(1, 2, 3, 4);
		img.setColor("RED");
		img.draw();
	}
}
