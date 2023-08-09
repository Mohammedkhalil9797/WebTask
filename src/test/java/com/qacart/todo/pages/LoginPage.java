package com.qacart.todo.pages;
import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    private final By email = By.xpath("//input[@id='email']");

    private final By password = By.xpath("//input[@id='password']");

    private final By login2 = By.xpath("//span[@class='MuiButton-label']");
    private final By test=By.xpath("//h3[.='Social Media']");
    private final By add = By.cssSelector("[data-testid='add']");
    private final By add2 = By.cssSelector(".MuiInputBase-input");
    private final By tt=By.xpath("//span[@class='icon icon-cloud-arrow-up cursor-pointer']");

    public void login() throws Exception {

        ElemenetAction.navigate("https://qacart-todo.herokuapp.com");
        ElemenetAction.sendKeys(email, "test97@gmail.com");
        ElemenetAction.sendKeys(password, "Test123@");
        ElemenetAction.clickAction(login2);
        ElemenetAction.clickAction(add);
        ElemenetAction.sendKeys(add2,"hi");

    }

    public void up() throws AWTException, InterruptedException {
        ElemenetAction.uploadFiles(tt,"C:\\Users\\MohammadKhalil\\OneDrive - Quality Professionals\\Desktop\\EssCase.png");
    }
}
