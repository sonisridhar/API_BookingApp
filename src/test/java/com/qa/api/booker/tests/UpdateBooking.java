package com.qa.api.booker.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.booker.helper.BookingHelper;
import com.qa.api.booker.pojo.Booking;
import com.qa.api.booker.utils.BookingAppUtil;

public class UpdateBooking extends BookingAppUtil {
	
	BookingHelper helper;
	Booking booking;
	
	@DataProvider
	public Object[][] getBookingDetails() {
		return new Object[][] {{"Advik","Jena",500,true,"BreakFast","2024-07-01","2024-07-02","Aradhya","Jena"}};
	}
	
	@Test(dataProvider = "getBookingDetails" )
	public void updateBookingAPI(String fName, String lName,int tPrice, boolean dPrice ,String needs,
			String chknDt,String coutDt,String updatedFName, String updatedLName) {
		
		helper = new BookingHelper(fName, lName, tPrice, dPrice, needs, chknDt, coutDt);
		 booking = helper.updateBookingAPI(fName, lName, tPrice, dPrice, needs, chknDt, coutDt,updatedFName,updatedLName);
		
		String first_Name = booking.getFirstname();/*fetchJsonValue(response, "firstname");*/
		//String last_Name = fetchJsonValue(response, "lastname");
		
		System.out.println(first_Name);
		//System.out.println(last_Name);
		
	}

}
