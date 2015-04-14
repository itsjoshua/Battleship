package com.joshua.battleship;

public class Square {
	
	private Integer x;
	private Integer y;
	private Boolean occupied;
	private String color;
	
	public Square(Integer x, Integer y, Boolean occupied) {
		this.x = x;
		this.y = y;
		this.occupied = occupied;
		this.color = "white";
	}
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
