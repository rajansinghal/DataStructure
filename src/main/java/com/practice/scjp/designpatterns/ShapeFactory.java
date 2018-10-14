package com.practice.scjp.designpatterns;

public class ShapeFactory {

	
	public Shape getShape(String shapeType){
		if(shapeType.equalsIgnoreCase("circle")){
			
			return new Circle();
		}else if(shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}
		return null;
		
	}
}
