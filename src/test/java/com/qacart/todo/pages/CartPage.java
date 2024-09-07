package com.qacart.todo.pages;

import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class CartPage extends BaseTest {
    public CartPage() {
        PageFactory.initElements(driver, this);
    }
    private final By checkFromProduct1=By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private final By checkFromProduct2=By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By checkoutButton=By.xpath("//button[@data-test='checkout']");
    public void checkFromCart() throws IOException {
        Assert.assertEquals(ElemenetAction.getUrl(),"https://www.saucedemo.com/cart.html");
        Assert.assertTrue(ElemenetAction.isDisplayed(checkFromProduct1));
        Assert.assertTrue(ElemenetAction.isDisplayed(checkFromProduct2));
        ElemenetAction.clickAction(checkoutButton);


    }
}
