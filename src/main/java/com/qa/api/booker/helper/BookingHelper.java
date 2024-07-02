package com.qa.api.booker.helper;

import static io.restassured.RestAssured.given;

import com.qa.api.booker.constants.EndPoints;
import com.qa.api.booker.pojo.Booking;
import com.qa.api.booker.pojo.GetBookingDetails;
import com.qa.api.booker.utils.BookingAppUtil;
import com.qa.api.booker.utils.PayLoad;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingHelper {

	public String fName;
	public String lName;
	public int tPrice;
	public boolean dPrice;
	public String needs;
	public String chknDt;
	public String coutDt;
	
	PayLoad payload;
	static RequestSpecification req;
	static RequestSpecification auth;
	static Response res;
	BookingAppUtil util;
	String booking;
	public static Booking bookingDetails;
	
	public BookingHelper() {
		
	}

	public BookingHelper(String fName, String lName, int tPrice, boolean dPrice, String needs, String chknDt,
			String coutDt) {
		this.fName = fName;
		this.lName = lName;
		this.tPrice = tPrice;
		this.dPrice = dPrice;
		this.needs = needs;
		this.chknDt = chknDt;
		this.coutDt = coutDt;

	}
	
	public String getToken() {
		util = new BookingAppUtil();
		auth = given().log().all().spec(util.requestSpec()).body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}");
		res = auth.when().post("/auth").then().extract().response();
		String token = util.fetchJsonValue(res.asString(), "token");
		System.out.println("============"+token);
		return token;
	}

	public GetBookingDetails createBookingAPI(String fName, String lName, int tPrice, boolean dPrice, String needs, String chknDt,
			String coutDt) {

		payload = new PayLoad();
		util = new BookingAppUtil();

		req = given().log().all().spec(util.requestSpec())
				.body(payload.getCreateBookingPayload(fName, lName, tPrice, dPrice, needs, chknDt, coutDt));
		
		GetBookingDetails bookDetails = 
				req.when().post(EndPoints.Create_Booking).then().log().all().extract().as(GetBookingDetails.class);
		
		return bookDetails;

	}
	
	public Booking updateBookingAPI(String fName, String lName, int tPrice, boolean dPrice, String needs, String chknDt,
			String coutDt,String updatedFN,String updatedLN) {
		
		util = new BookingAppUtil();
		String bookingID = createBookingAPI(fName, lName, tPrice, dPrice, needs, chknDt, coutDt).getBookingid();
		
		
		req = given().log().all().spec(util.updateRequestSpec()).pathParam("id", bookingID).body(PayLoad.updateBookingAPIPayLoad(updatedFN, updatedLN));
		
		bookingDetails = req.when().patch(EndPoints.Update_Booking).then().log().all().extract().as(Booking.class);
		return bookingDetails;
		
		
	}

}
