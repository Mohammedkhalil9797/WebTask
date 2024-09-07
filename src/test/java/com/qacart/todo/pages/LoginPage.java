package com.qacart.todo.pages;
import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.enums.UserType;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }



    private final By username = By.xpath("//input[@data-test='username']");
    private final By password = By.xpath("//input[@data-test='password']");

    private final By loginButton = By.xpath("//input[@data-test='login-button']");
    private final By error = By.xpath("//h3[@data-test='error']");
    public void url() throws Exception {

        ElemenetAction.navigate(ConfigUtils.getInstance().getBaseUrl());
        Assert.assertEquals(ElemenetAction.getUrl(), "https://www.saucedemo.com/");

    }
    public void sendInvalidUsernameAndPassword(String userName, String Password) throws Exception {

        ElemenetAction.sendKeys(username,userName);
        ElemenetAction.sendKeys(password,Password);
        ElemenetAction.clickAction(loginButton);
        Assert.assertEquals(ElemenetAction.getText(error),"Epic sadface: Username and password do not match any user in this service");
    }
    public void validLogin(UserType userType) throws Exception {

        ElemenetAction.sendKeys(username,userType.userName);
        ElemenetAction.sendKeys(password,userType.password);
        ElemenetAction.clickAction(loginButton);
        Assert.assertEquals(ElemenetAction.getUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
