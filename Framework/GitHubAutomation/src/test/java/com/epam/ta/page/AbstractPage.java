package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected abstract AbstractPage openPage();
	protected final int WAIT_TIMEOUT_SECONDS = 20;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	protected WebElement waitForElementLocatedBy(String xpathOfElement){
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathOfElement)));
	}

	protected WebElement waitForElementToBeClickable(String xpathOfElement){
		return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOfElement)));
	}
}
