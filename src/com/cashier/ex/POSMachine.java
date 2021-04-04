package com.cashier.ex;

public class POSMachine {
	
	private double change;

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		if(change<10000) {
			System.out.println("거스름돈이 10000원 미만입니다. 확인해 주세요.");
		}
		this.change = change;
	}
	
	



	
	
}
