package com.corrientazo.droneProject.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	
	public static ArrayList<String> readFile(String path, String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			File file = new File(path + fileName);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void writeFile(String path, String fileName, ArrayList<String> fullReport) {
		try {
			File reportFile = new File(path + fileName);
			reportFile.createNewFile();
			FileWriter fileWriter = new FileWriter(reportFile);
			fileWriter.write("== Reporte de entregas == \n");				
			for(String report : fullReport) {
				fileWriter.write(report);				
				fileWriter.write("\n");				
			}
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String fileNameIterator(int numFile, String file) {
		return numFile < 10?
				file.replaceAll("#", "0" + Integer.toString(numFile)):
				file.replaceAll("#", Integer.toString(numFile));
	}

}
