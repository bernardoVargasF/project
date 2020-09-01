package com.corrientazo.droneProject.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.corrientazo.droneProject.entities.Drone;
import com.corrientazo.droneProject.main.Delivery;
import com.corrientazo.droneProject.utils.Cardinal;

public class DeliveryTest {
	Delivery delivery = new Delivery();
	
	@Test
	public void testDelivery01() throws Exception{
		Drone initDrone = new Drone(0,0, Cardinal.NORTE);
		Drone finalPosition = new Drone(-2, 4, Cardinal.OCCIDENTE);
		Drone test = delivery.getDeliveredPosition(initDrone, "AAAAIAA", 0);
		
		assertEquals(finalPosition.getX(),test.getX());
		assertEquals(finalPosition.getY(),test.getY());
		assertEquals(finalPosition.getCardinal(),test.getCardinal());
	}
	
	@Test
	public void testDelivery02() throws Exception{
		Drone initDrone = new Drone(-2,4, Cardinal.OCCIDENTE);
		Drone finalPosition = new Drone(-1, 3, Cardinal.SUR);
		Drone test = delivery.getDeliveredPosition(initDrone, "DDDAIAD", 0);
		
		assertEquals(finalPosition.getX(),test.getX());
		assertEquals(finalPosition.getY(),test.getY());
		assertEquals(finalPosition.getCardinal(),test.getCardinal());
	}
	
	@Test
	public void testDelivery03() throws Exception{
		Drone initDrone = new Drone(-1, 3, Cardinal.SUR);
		Drone finalPosition = new Drone(0, 0, Cardinal.OCCIDENTE);
		Drone test = delivery.getDeliveredPosition(initDrone, "AAIADAD", 0);
		
		assertEquals(finalPosition.getX(),test.getX());
		assertEquals(finalPosition.getY(),test.getY());
		assertEquals(finalPosition.getCardinal(),test.getCardinal());
	}
	

}
