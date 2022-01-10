package com.mishra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class SingleJSON {
	public static void main(String[] args) throws MalformedURLException, IOException {
		// Consume a web service (Rest API)
		// We must know endPoint (url)
		String endpoint = "http://localhost:8080/REST-FIRST-DEMO/Course/json/S101";
		// create an object of url class given by core java as it's core java project
		// using package java.net.*

		URL url = new URL(endpoint);

		// now to connect this url call open connection method
		URLConnection connection = url.openConnection();

		/*
		 * to send something to server, we need OutputStream to recieve response given
		 * by server we need InputStream
		 */
		// now getting response
		InputStream inputStream = connection.getInputStream();
		// reading the response given by server
		// InputStream is read Byte based Stream and convert it into character based
		// stream
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// bufferRead gives ability to read the data line by line
		// buffer Reader accepts only charachter based String
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		StringBuffer stringBuffer = new StringBuffer();
		// readLine method is used to read the line
		while (true) {
			String line = bufferedReader.readLine();
			if (line == null) {
				break;
			}
			// making Buffered Stream into String
			stringBuffer.append(line);
		}
		// converting string buffer into String
		String data = stringBuffer.toString();
		System.out.println(data);
		System.out.println("Paring JSON String");

		// creating JSon object to pares String into json as for java above line is just
		// a String
		JSONObject json= new JSONObject(data); 
		
			String code=json.getString("code");
			String title=json.getString("title");
			String subject=json.getString("subject");
			int fees= json.getInt("fees");
			System.out.println(code+" "+title+" "+subject+" "+fees);
		
		
	}
}
