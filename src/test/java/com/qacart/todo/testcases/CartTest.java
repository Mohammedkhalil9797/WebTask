package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.*;
import com.qacart.todo.utils.RetryAnalyzer;
import org.testng.annotations.Test;

import static com.qacart.todo.enums.UserType.TaskLogin;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addExpensiveProduct() throws Exception {

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CartPage cartPage=new CartPage();
        CheckoutPage checkoutPage=new CheckoutPage();
        SubmitCheckoutPage submitCheckoutPage=new SubmitCheckoutPage();
        loginPage.url();
        loginPage.validLogin(TaskLogin);
        homePage.addProductToCart();
        cartPage.checkFromCart();
        checkoutPage.checkout();
        submitCheckoutPage.submitCheckout();

    }
}
