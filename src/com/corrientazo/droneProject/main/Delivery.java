package com.corrientazo.droneProject.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.corrientazo.droneProject.entities.Drone;
import com.corrientazo.droneProject.utils.Cardinal;
import com.corrientazo.droneProject.utils.Constants;
import com.corrientazo.droneProject.utils.FileManager;

public class Delivery {
	
	public HashMap<Integer, ArrayList<String>> getDronesRoutes() {
		HashMap<Integer, ArrayList<String>> dronesRoutes = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> routes = new ArrayList<String>();
		String routesPath = Constants.ROUTES_PATH;
		String routesFile = Constants.ROUTES_FILE_NAME;
		String fileName;
		for(int i = 1; i <= Constants.MAX_DRONES; i++) {
			fileName = FileManager.fileNameIterator(i, routesFile);
			routes = FileManager.readFile(routesPath, fileName);
			dronesRoutes.put(i, routes);
		}
		return dronesRoutes;
	}
	
	public void deliveryReport(HashMap<Integer, ArrayList<String>> deliveries) {
		String reportPath = Constants.REPORTS_PATH;
		String reportFile = Constants.REPORT_FILE_NAME;
		String fileName;
		for(int i = 1; i<= Constants.MAX_DRONES; i++) {
			fileName = FileManager.fileNameIterator(i, reportFile);			
			FileManager.writeFile(reportPath, fileName, deliveries.get(i));
		}
	}
	
	public Drone getDeliveredPosition(Drone initDrone, String deliveryString, int fileNumber) throws Exception {
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
				if(x > Constants.MAX_BLOCKS || x < -(Constants.MAX_BLOCKS) || 
						y > Constants.MAX_BLOCKS || y < -(Constants.MAX_BLOCKS )) {
					throw new Exception("Maximum number of blocks exceeded in file number: " + fileNumber);
				}
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
				throw new Exception("Incorrect step for the route: " + step + " in route: " + 
						deliveryString + "on file number: " + fileNumber);
			}
		}
		Drone deliveredPosition = new Drone(x, y, currentCardinal);
		return deliveredPosition;
	}
}
