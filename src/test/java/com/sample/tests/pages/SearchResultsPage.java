package com.sample.tests.pages;

import com.sample.framework.ui.Alias;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import org.openqa.selenium.WebDriver;

@Alias("Search Results")
public class SearchResultsPage extends Page {
    @Alias("Title")
    @FindBy(locator = "//h1")
    public Control textSubtitle;

    @FindBy(locator = "ss")
    public Edit editDestination;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
