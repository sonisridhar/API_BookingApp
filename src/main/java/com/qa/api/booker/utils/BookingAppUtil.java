package com.qa.api.booker.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.api.booker.helper.BookingHelper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class BookingAppUtil {

	public static RequestSpecification req;
	public static Properties prop;
	BookingHelper helper = new BookingHelper();

	public JsonPath rawJsonPath(String response) {
		JsonPath path = new JsonPath(response);
		return path;
	}

	public String fetchJsonValue(String response, String val) {
		return rawJsonPath(response).get(val).toString();
	}

	public RequestSpecification requestSpec() {

		req = new RequestSpecBuilder().setBaseUri(initProp().getProperty("baseURI"))
				.addHeader("Content-Type", "application/json").build();
		return req;
	}

	public RequestSpecification updateRequestSpec() {

		req = new RequestSpecBuilder().setBaseUri(initProp().getProperty("baseURI"))
				.addHeader("Content-Type", "application/json").addHeader("Accept", "application/json")
				.addHeader("Cookie", "token="+helper.getToken()).build();
		return req;
	}

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		return prop;
	}
}
