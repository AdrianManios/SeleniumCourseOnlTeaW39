package pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coderslab.seleniumcourseonlteaw39.Utils;
import pl.coderslab.seleniumcourseonlteaw39.pageobjectpattern.UserData;

public class CreateAnAccountPage {
    @FindBy(id = "customer_firstname")
    WebElement firstNameInputBox;
    @FindBy(id = "customer_lastname")
    WebElement lastNameInputBox;
    @FindBy(id = "email")
    WebElement customerEmailInputBox;
    @FindBy(id = "passwd")
    WebElement passwordInputBox;
    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;
    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public CreateAnAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillForm(UserData userData) {
        firstNameInputBox.sendKeys(userData.getFirstName());
        lastNameInputBox.sendKeys(userData.getLastName());
        passwordInputBox.sendKeys(userData.getPassword());
        Utils.setCheckbox(newsletterCheckbox, userData.isSignUpForNewsletter());
    }

    public void clickRegister() {
        registerButton.click();
    }

    public boolean areMandatoryFormFieldsVisibleAndEnabled() {
        return Utils.isDisplayedAndEnabled(firstNameInputBox) &&
            Utils.isDisplayedAndEnabled(lastNameInputBox) &&
            Utils.isDisplayedAndEnabled(passwordInputBox);
    }

    public String getEmail() {
        return customerEmailInputBox.getAttribute("value");
    }
}
