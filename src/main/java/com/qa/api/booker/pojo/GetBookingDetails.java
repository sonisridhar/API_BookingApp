package com.qa.api.booker.pojo;

public class GetBookingDetails {
	
	private String bookingid;
	private Booking booking;
	//private BookingDates bookingdates;
	
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
//	public BookingDates getBookingdates() {
//		return bookingdates;
//	}
//	public void setBookingdates(BookingDates bookingdates) {
//		this.bookingdates = bookingdates;
//	}
	
	
	

}
