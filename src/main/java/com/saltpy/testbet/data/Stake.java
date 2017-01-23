package com.saltpy.testbet.data;

public class Stake {
	
	private final int pence;

	public Stake(int pence) {
		this.pence = pence;
	}

	@Override
	public String toString() {
		String pennyStringPart = String.valueOf(pence % 100);
		if (pennyStringPart.length() == 1) {
			pennyStringPart = "0" + pennyStringPart;
		}
 		
		return String.valueOf(pence / 100) + '.' + pennyStringPart;
	}

	public int penceValue() {
		return pence;
	}

}
