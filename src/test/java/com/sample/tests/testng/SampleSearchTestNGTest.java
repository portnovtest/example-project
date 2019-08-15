package com.sample.tests.testng;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleSearchTestNGTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        driver = Driver.current();
        driver.get(Configuration.get("url"));

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSampleSearch() throws InterruptedException {
        driver.findElement(By.id("ss")).click();
        driver.findElement(By.id("ss")).clear();
        driver.findElement(By.id("ss")).sendKeys("London");
        Thread.sleep(1000);
        driver.findElements(By.cssSelector("li.c-autocomplete__item")).get(0).click();
        driver.findElements(By.cssSelector("div.sb-date-field__display")).get(0).click();
        driver.findElement(By.xpath("//td[contains(@class, 'c2-day-s-today')]")).click();
        driver.findElements(By.xpath("//input[@name='sb_travel_purpose']")).get(0).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("ss")).click();
    }
}
