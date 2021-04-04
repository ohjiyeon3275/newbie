package com.customer.ex;

public class Customer {
	
	private double membership;
	private boolean discountCard;
	
	
	public double getMembership() {
		return membership;
	}
	public void setMembership(double membership) {
		this.membership = membership;
	}
	public String isDiscountCard() {
		if(discountCard == true) {
			return "예";
		}else {
			return "아니오";
		}
	}
	public void setDiscountCard(boolean discountCard) {
		this.discountCard = discountCard;
	}
	
	
	
	
	
}
