package com.qacart.todo.pages;

import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.ExcelUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;


import java.io.IOException;

public class HomePage extends BaseTest {
    public HomePage (){
        PageFactory.initElements(driver, this);
    }
private final By filter=By.xpath("//select[@data-test='product-sort-container']");
    private final By product1=By.xpath("//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']");
    private final By product2=By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By cart=By.xpath("//a[@data-test='shopping-cart-link']");
    public void addProductToCart() throws IOException {
        ElemenetAction.select(filter,"hilo");
        ElemenetAction.clickAction(product1);
        ElemenetAction.clickAction(product2);
        ElemenetAction.clickAction(cart);


    }





}
