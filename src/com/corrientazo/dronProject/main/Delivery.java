package com.corrientazo.dronProject.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.corrientazo.dronProject.entities.Drone;
import com.corrientazo.dronProject.utils.Cardinal;
import com.corrientazo.dronProject.utils.Constants;
import com.corrientazo.dronProject.utils.FileManager;

public class Delivery {
	FileManager fileManager = new FileManager();
	
	public HashMap<Integer, ArrayList<String>> getRoutes() {
		HashMap<Integer, ArrayList<String>> routes = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> route = new ArrayList<String>();
		String routesPath = Constants.ROUTES_PATH;
		String routesFile = Constants.ROUTES_FILE_NAME;
		String fileName;
		for(int i = 1; i <= Constants.MAX_DRONES; i++) {
			fileName = fileManager.fileNameIterator(i, routesFile);
			route = fileManager.readFile(routesPath, fileName);
			System.out.println("Num dron: " + i + ", archivo: " + route.toString());
			routes.put(i, route);
		}
		return routes;
	}
	
	public void deliveryReport(ArrayList<String> drones) {
		String reportPath = Constants.REPORTS_PATH;
		String reportFile = Constants.REPORT_FILE_NAME;
		String fileName;
		for(int i = 1; i<= Constants.MAX_DRONES; i++) {
			fileName = fileManager.fileNameIterator(i, reportFile);			
			fileManager.writeFile(reportPath, fileName, drones);
		}
	}
	
	public Drone getDeliveryPosition(Drone initDrone, String deliveryString) {
		int x = initDrone.getX();
		int y = initDrone.getY();
		Cardinal currentCardinal = initDrone.getCardinal();
		char[] deliverySteps = deliveryString.toCharArray();
		for(char step : deliverySteps) {
			switch(step) {
			case 'A':
				if(currentCardinal.equals(Cardinal.NORTE)) y+=1;
				if(currentCardinal.equals(Cardinal.SUR)) y-=1;
				if(currentCardinal.equals(Cardinal.OCCIDENTE)) x-=1;
				if(currentCardinal.equals(Cardinal.ORIENTE)) x+=1;
				break;
			case 'I':
				if(currentCardinal.equals(Cardinal.NORTE)) {
					currentCardinal = Cardinal.OCCIDENTE; 
					break;
				}
				if(currentCardinal.equals(Cardinal.SUR)) {
					currentCardinal = Cardinal.ORIENTE; 
					break;
				}
				if(currentCardinal.equals(Cardinal.OCCIDENTE)) {
					currentCardinal = Cardinal.SUR;
					break;
				}
				if(currentCardinal.equals(Cardinal.ORIENTE)) {
					currentCardinal = Cardinal.NORTE;
					break;
				}				
			case 'D':
				if(currentCardinal.equals(Cardinal.NORTE)) {
					currentCardinal = Cardinal.ORIENTE;
					break;
				}
				if(currentCardinal.equals(Cardinal.SUR)) {
					currentCardinal = Cardinal.OCCIDENTE;
					break;
				}
				if(currentCardinal.equals(Cardinal.OCCIDENTE)) {
					currentCardinal = Cardinal.NORTE;
					break;
				}
				if(currentCardinal.equals(Cardinal.ORIENTE)) {
					currentCardinal = Cardinal.SUR;
					break;
				};
			default:
				// TODO error
			}
		}
		Drone deliveryPosition = new Drone(x, y, currentCardinal);
		return deliveryPosition;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Delivery delivery = new Delivery();
//		delivery.getRoutes();
//		
//		delivery.deliveryReport(drones);
		
		
	}

}
