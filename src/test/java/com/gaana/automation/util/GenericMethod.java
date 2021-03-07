package com.gaana.automation.util;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gaana.test.base.BaseAutomation;
import com.google.common.base.Function;

public class GenericMethod extends BaseAutomation {
	
	public void click(By elementLocator) {
		WaitFor_visibility(elementLocator);
		WaitFor_clickable(elementLocator);
		driver.findElement(elementLocator).click();
	}	
	public void EnterText(By elementLocator, String text) {
		WaitFor_visibility(elementLocator);
		driver.findElement(elementLocator).clear();
		driver.findElement(elementLocator).sendKeys(text);
	}
	public void selectFromDropDwnByVisibleText(By elementLocator, String input) {
		Select dropdown = new Select(driver.findElement(elementLocator));
		dropdown.selectByVisibleText(input);
	}
	public void selectFromDropDwnByIndex(By elementLocator, int input) {
		Select dropdown = new Select(driver.findElement(elementLocator));
		dropdown.selectByIndex(input);
	}
	public String getText(By elementLocator) {
		WaitFor_visibility(elementLocator);
		return driver.findElement(elementLocator).getText();
	}
	public String getParentWindowHandle() {
		return driver.getWindowHandle();
	}
	public void switchToNewWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String newWindow : windowHandles) {
				driver.switchTo().window(newWindow);		
		}
	}
	public void switchToParenttWindow(String parentWinHandle) {
		driver.switchTo().window(parentWinHandle);
	}

	public boolean isDisplay(By elementLocator) {
		WaitFor_visibility(elementLocator);
		return driver.findElement(elementLocator).isDisplayed();
	}
	public boolean isNotVisible(By elementLocator) {
		if(!driver.findElement(elementLocator).isDisplayed()) {
			return true;
		}
		return false;
		
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);	
	}
	public int getElementSize(By elementLocator) {
		return driver.findElements(elementLocator).size();
	}
	public void ScrollToELement(By elementLocator) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(elementLocator));
	}
	public void JSClick(By elementLocator) {
		WaitFor_visibility(elementLocator);
		WaitFor_clickable(elementLocator);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(elementLocator));
	}
	public void actionClick(By elementLocator) {
		new Actions(driver).moveToElement(driver.findElement(elementLocator)).click().perform();
	}
	public boolean isTextVisisble(String elementName) {
		if(driver.getPageSource().contains(elementName)) {
			return true;
		}
		return false;
	}
	public static void ScrollDownWithCordinate(int x, int y)  {
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")");
	}
	public static void ScrollAutomatically(By elementLocator) throws InterruptedException {
		Point hoverItem =driver.findElement(elementLocator).getLocation();
		((JavascriptExecutor)driver).executeScript("return window.title;");  
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY()-300)+");");
	}
	public void scrollToBottom() {
		long longScrollHeight = (Long) ((JavascriptExecutor) driver).executeScript("return Math.max("
	            + "document.body.scrollHeight, document.documentElement.scrollHeight,"
	            + "document.body.offsetHeight, document.documentElement.offsetHeight,"
	            + "document.body.clientHeight, document.documentElement.clientHeight);"
	    );
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + longScrollHeight + ");");
    }
	public void scrollToBottomInfinite() throws InterruptedException {
		long newHeight;
		long lastHeight = 0;
		newHeight = (Long) ((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight");
		while(newHeight>lastHeight) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + newHeight + ");");
			lastHeight=newHeight;
			Thread.sleep(2000);
			newHeight = (Long) ((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight");			
		}
	}
	public void mouseHoverToElement(By elementLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(elementLocator)).perform();
	}
	
	public void WaitFor_visibility(By elementLocator) {
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	public static void WaitFor_clickable(By elementLocator) {
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(elementLocator));
	}
	public void customWaitFor_visibility(By elementLocator,long timeoutInSec) {
		(new WebDriverWait(driver, timeoutInSec)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	public static void customWaitFor_clickable(By elementLocator,long timeoutInSec) {
		(new WebDriverWait(driver,timeoutInSec)).until(ExpectedConditions.elementToBeClickable(elementLocator));
	}
	public void WaitFor_Invisibility(By elementLocator) {
	        (new WebDriverWait(driver, 30)).until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
	}
	
	
	public void fluentWaitFor_visibility(final By elementLocator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(20, TimeUnit.SECONDS)
	            .pollingEvery(1, TimeUnit.SECONDS)
	            .ignoring(NoSuchElementException.class);
	   wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver driver) {
	            return driver.findElement(elementLocator);
	        }
	    });
		
		
		
		/*(new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).
				pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class))
		.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));*/
		
	}
	
	
	
}

