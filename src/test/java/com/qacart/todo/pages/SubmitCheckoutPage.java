package com.qacart.todo.pages;

import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class SubmitCheckoutPage extends BaseTest {
    public SubmitCheckoutPage() {
        PageFactory.initElements(driver, this);
    }
    private final By price1=By.xpath("//div[@data-test='inventory-item-price']");
    private final By price2=By.xpath("(//div[@data-test='inventory-item-price'])[2]");
    private final By totalPrice=By.xpath("//div[@data-test='subtotal-label']");
    private final By overView=By.xpath("//span[@data-test='title']");
    private final By finishButton=By.xpath("//button[@data-test='finish']");
    private final By thankYouMSG=By.xpath("//h2[@data-test='complete-header']");
    private final By dispatchedMSG=By.xpath("//div[@data-test='complete-text']");
    public void submitCheckout() throws IOException {
        Assert.assertEquals(ElemenetAction.getUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(ElemenetAction.getText(overView),"Checkout: Overview");
        String numberAsString = ElemenetAction.getText(price1);
        numberAsString = numberAsString.replace("$", "");
        double numberAsInt = Double.parseDouble(numberAsString);
        String numberAsString2 = ElemenetAction.getText(price2);
        numberAsString2 = numberAsString2.replace("$", "");
        double numberAsInt2 = Double.parseDouble(numberAsString2);
        double sumOfProduct=numberAsInt+numberAsInt2;
        String totalString = ElemenetAction.getText(totalPrice);
        totalString = totalString.replace("Item total: $", "");
        double totalPrice = Double.parseDouble(totalString);
        Assert.assertEquals(totalPrice,sumOfProduct);
        ElemenetAction.scrollTo(finishButton);
        ElemenetAction.clickAction(finishButton);
        Assert.assertEquals(ElemenetAction.getText(thankYouMSG),"Thank you for your order!");
        Assert.assertEquals(ElemenetAction.getText(dispatchedMSG),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
