package com.corrientazo.dronProject.entities;

import com.corrientazo.dronProject.utils.Cardinal;

public class Drone {
	private int x;
	private int y;
	private Cardinal cardinal;
	
	public Drone(int x, int y, Cardinal cardinal) {
		super();
		this.x = x;
		this.y = y;
		this.cardinal = cardinal;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Cardinal getCardinal() {
		return cardinal;
	}
	public void setCardinal(Cardinal cardinal) {
		this.cardinal = cardinal;
	}
	
	public String getPosition() {
		return "(" + this.x + ", " + this.y + ") dirección " + this.cardinal.getCardinal();				
	}
}
