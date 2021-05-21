package com.zinio.web.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonFile {
	
	public static String getData(String objectName) {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(new FileReader("language.json"));
			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;
			
			// Reading the String
			String name = (String) jsonObject.get(objectName);
			return name;
			
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}