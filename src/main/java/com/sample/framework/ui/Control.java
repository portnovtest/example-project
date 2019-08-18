package com.sample.framework.ui;

import com.sample.framework.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class Control {
    protected static final long TIMEOUT = Configuration.timeout();
    private WebDriver driver;
    private By locator;

    public Control(WebDriver driver, By locator) {
        super();
        this.driver = driver;
        this.locator = locator;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public By getLocator() {
        return locator;
    }
    public WebElement element(){
        return driver.findElement(locator);
    }
    public WebElement element(int index){
        return driver.findElements(locator).get(index);
    }
    public boolean exits(long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    public boolean visible(long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    public boolean exists(){
        return exits(TIMEOUT);
    }
    public boolean visible(){
        return visible(TIMEOUT);
    }
    public void click() {
        assertTrue(exists(),"Unable to find element: " + this.locator.toString());
        assertTrue(visible(),"Unable to find element: " + this.locator.toString());
        this.element().click();
    }
    public String getText(){
        assertTrue(exists(), "Unable to find element: " + this.locator.toString());
        return this.element().getText();
    }
}
