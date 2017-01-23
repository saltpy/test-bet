package com.saltpy.testbet.harness;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Driver {
	
	private final WebDriver wd;

	public Driver(WebDriver wd) {
		this.wd = wd;
	}
	
	public void click(WebElement el) {
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", el);
		((JavascriptExecutor) wd).executeScript("arguments[0].click();", el);
		wait(200);
	}

	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void click(By by) {
		click(wd.findElements(by).get(0));
	}

	public void typeText(WebElement el, String text) {
		click(el);
		el.sendKeys(text);
		wait(200);
	}

	public void typeText(By by, String text) {
		typeText(wd.findElement(by), text);
	}

	public List<WebElement> findElements(By by) {
		return wd.findElements(by);
	}

	public WebElement findElement(By by) {
		return wd.findElement(by);
	}

	public void get(String address) {
		wd.get(address);
	}

}
