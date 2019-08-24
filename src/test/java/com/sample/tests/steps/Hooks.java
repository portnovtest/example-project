package com.sample.tests.steps;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hooks {

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        Driver.add(Configuration.get("browser"),cap);
        Driver.current().get(Configuration.get("url"));

    }
    @After
    public void tearDown(){
        Driver.current().quit();
    }
}
