package com.corrientazo.dronProject.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.corrientazo.dronProject.entities.Drone;
import com.corrientazo.dronProject.utils.Cardinal;

public class Exercise {

	public static void main(String[] args) {
		Delivery delivery = new Delivery();
		HashMap<Integer, ArrayList<String>> dronesRoutes = delivery.getDronesRoutes();
		HashMap<Integer, ArrayList<String>> dronesDeliveries = new HashMap<Integer, ArrayList<String>>();
		Drone deliveryDrone = new Drone(0, 0, Cardinal.NORTE);
		for(int i = 1; i <= dronesRoutes.size(); i++) {
			ArrayList<String> deliveries = new ArrayList<String>();
			for(String route : dronesRoutes.get(i)) {
				deliveryDrone = delivery.getDeliveredPosition(deliveryDrone, route);
				deliveries.add(deliveryDrone.getPosition());
			}
			dronesDeliveries.put(i, deliveries);
			deliveryDrone = new Drone(0, 0, Cardinal.NORTE);
		}
		
		delivery.deliveryReport(dronesDeliveries);
	}

}
