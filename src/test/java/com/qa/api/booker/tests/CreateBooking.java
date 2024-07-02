package com.qa.api.booker.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.booker.constants.EndPoints;
import com.qa.api.booker.helper.BookingHelper;
import com.qa.api.booker.pojo.GetBookingDetails;
import com.qa.api.booker.utils.BookingAppUtil;
import com.qa.api.booker.utils.PayLoad;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class CreateBooking extends BookingAppUtil {
	
	PayLoad payload;
	static RequestSpecification createReq;
	BookingHelper helper;
	GetBookingDetails bookDetails ;
	
	@DataProvider
	public Object[][] getBookingDetails() {
		return new Object[][] {{"Advik","Jena",500,true,"BreakFast","2024-07-01","2024-07-02"}};
	}
	
	@Test(dataProvider="getBookingDetails")
	public void addBooking(String fName, String lName,int tPrice, boolean dPrice ,String needs,
			String chknDt,String coutDt) {
//		payload = new PayLoad();
//		
//		createReq = 
//				given().log().all().spec(requestSpec())
//		        .body(payload.getCreateBookingPayload(fName, lName, tPrice, dPrice, needs, chknDt, coutDt));
//		
//		GetBookingDetails bookDetails = 
//				createReq.when().post(EndPoints.Create_Booking).then().log().all().extract().as(GetBookingDetails.class);
		
		helper = new BookingHelper(fName, lName, tPrice, dPrice, needs, chknDt, coutDt);
		bookDetails = helper.createBookingAPI(fName, lName, tPrice, dPrice, needs, chknDt, coutDt);
	
	String lastName = bookDetails.getBooking().getLastname();
	String bookingID = bookDetails.getBookingid();
	System.out.println(bookingID);
		
	Assert.assertEquals(lName, lastName);
		
		
	}

}
