package com.qa.api.booker.pojo;

public class BookingDates {
	/**
	 * "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
	 */
	private String checkin;
	private String checkout;
	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
