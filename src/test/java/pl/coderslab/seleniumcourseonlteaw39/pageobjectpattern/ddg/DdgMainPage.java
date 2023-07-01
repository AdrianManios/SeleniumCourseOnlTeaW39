package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.ddg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DdgMainPage {
    @FindBy(id = "search_form_input_homepage")
    private WebElement searchInput;

    public DdgMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterSearchPhrase(String phrase) {
        searchInput.sendKeys(phrase);
    }
}
