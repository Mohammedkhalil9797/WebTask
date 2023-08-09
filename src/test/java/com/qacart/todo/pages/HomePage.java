package com.qacart.todo.pages;

import com.qacart.todo.actions.ElemenetAction;
import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage (){
        PageFactory.initElements(driver, this);
    }
    private final By add = By.cssSelector("[data-testid='add']");
    public final By add2 = By.cssSelector(".MuiInputBase-input");
    public void create()  {
        ElemenetAction.clickAction(add);

    }
}
