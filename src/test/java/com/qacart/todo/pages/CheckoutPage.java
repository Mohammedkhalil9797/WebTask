package com.qacart.todo.pages;

import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class CheckoutPage extends BaseTest {
    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }
    private final By fName=By.xpath("//input[@data-test='firstName']");
    private final By lName=By.xpath("//input[@data-test='lastName']");
    private final By zipCode=By.xpath("//input[@data-test='postalCode']");
    private final By continueButton=By.xpath("//input[@data-test='continue']");
    public void checkout() throws Exception {
        Assert.assertEquals(ElemenetAction.getUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        ElemenetAction.sendKeys(fName,faker.name().firstName());
        ElemenetAction.sendKeys(lName,faker.name().lastName());
        ElemenetAction.sendKeys(zipCode,faker.address().zipCode());
        ElemenetAction.clickAction(continueButton);

    }
}
