package com.saltpy.testbet.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saltpy.testbet.data.Odds;
import com.saltpy.testbet.data.Position;
import com.saltpy.testbet.data.Stake;
import com.saltpy.testbet.harness.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Returns {
	private Driver driver;
	private List<Position> betslip;

	public Returns() {
		driver = new Driver(Hooks.driver);
		betslip = new ArrayList<Position>();
	}

	@Given("^I have whitelisted cookies$")
	public void iHaveVisited() throws Throwable {
		driver.get("http://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
	}

	@Given("^I am on the English Premier League landing page$")
	public void iAmOn() throws Throwable {
		driver.get("http://sports.williamhill.com/betting/en-gb/football/competitions/english-premier-league");
	}

	@When("^I add a (\\d+) pence bet to my betslip$")
	public void iAddABetToMyBetslip(int pence) throws Throwable {
		Stake stake = new Stake(pence);
		WebElement el = driver.findElements(By.cssSelector(".event button")).get(0);
		Odds odds = new Odds(el);
		
		driver.click(el);
		driver.click(By.cssSelector(".toggle-betslip"));
		driver.typeText(By.cssSelector(".betslip-selection__stake-input"), stake.toString());

		betslip.add(new Position(odds, stake));
	}

	@Then("^my betslip is correct$")
	public void myBetslipIsCorrect() throws Throwable {
		List<WebElement> bets = driver.findElements(By.cssSelector(".betslip-selection__content"));
		assertEquals(betslip.size(), bets.size());

		if (betslip.size() != 1) {
			fail("Test Framework does not yet handle tests placing multiple bets or zero bets");
		}

		int expectedReturn = betslip.get(0).returns();
		int actualReturn = Math.round(100 * (Float.parseFloat(
				driver.findElement(By.cssSelector(".betslip-selection__estimated-returns-amount")).getText())));

		assertEquals(expectedReturn, actualReturn);
	}

}