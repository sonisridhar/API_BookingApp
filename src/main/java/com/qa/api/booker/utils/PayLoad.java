package com.qa.api.booker.utils;

import com.qa.api.booker.pojo.Booking;
import com.qa.api.booker.pojo.BookingDates;
import com.qa.api.booker.pojo.GetBookingDetails;

public class PayLoad {

	public Booking booking;
	public BookingDates dates;
	public GetBookingDetails details;

	public Booking getCreateBookingPayload(String fn, String ln, int tp, boolean dp, String needs, String chknDt,
			String chkoutDate) {

		booking = new Booking();
		dates = new BookingDates();
		dates.setCheckin(chknDt);
		dates.setCheckout(chkoutDate);

		booking.setFirstname(fn);
		booking.setLastname(ln);
		booking.setTotalprice(tp);
		booking.setDepositpaid(dp);
		booking.setAdditionalneeds(needs);
		booking.setBookingdates(dates);

		return booking;
	}

	public GetBookingDetails getBookingDetails() {

		details = new GetBookingDetails();
		return details;
	}
	
	public static String updateBookingAPIPayLoad(String ufn,String uln) {
		
		return "{\r\n"
				+ "    \"firstname\" : \""+ufn+"\",\r\n"
				+ "    \"lastname\" : \""+uln+"\"\r\n"
				+ "}";
	}

}
