package com.saltpy.testbet.data;

import org.openqa.selenium.WebElement;

public class Odds {

	private final int numerator;
	private final int denominator;

	public Odds(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Odds(WebElement oddsParent) {
		denominator = Integer.parseInt(oddsParent.getAttribute("data-denom"));
		numerator = Integer.parseInt(oddsParent.getAttribute("data-num"));
	}

	public float multiplier() {
		return 1 + ((float) numerator / denominator);
	}

}
