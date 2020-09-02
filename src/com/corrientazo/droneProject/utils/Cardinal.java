package com.corrientazo.droneProject.utils;

public enum Cardinal {
	NORTE("Norte"),
	SUR("Sur"),
	OCCIDENTE("Occidente"),
	ORIENTE("Oriente");
	
	private String cardinal;
	
	private Cardinal(String cardinal) {
		this.cardinal = cardinal;
	}
	
	public String getCardinal() {
		return this.cardinal;
	}
}
