package com.mishra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class CompleteJSON {
	public static void main(String[] args) throws IOException {
		String endPoint="http://localhost:8080/REST-FIRST-DEMO/Course/list/json";
		URL url= new URL(endPoint);
		URLConnection urlConnection= url.openConnection();
		InputStream inputStream= urlConnection.getInputStream();
		InputStreamReader reader= new InputStreamReader(inputStream);
		BufferedReader bufferedReader= new BufferedReader(reader);
		//Read Inputstream with bufferReader and converting into String
		String data=bufferedReader.readLine().toString();
		
		JSONArray jsonArray= new JSONArray(data);
		for(int i=0;i<jsonArray.length();i++) {
			JSONObject jsonObject= jsonArray.getJSONObject(i);
			String code=jsonObject.getString("code");
			String title=jsonObject.getString("title");
			String subject=jsonObject.getString("subject");
			int fees=jsonObject.getInt("fees");
			System.out.println(code+", "+title+", "+subject+", "+fees);
		}
	}
}
