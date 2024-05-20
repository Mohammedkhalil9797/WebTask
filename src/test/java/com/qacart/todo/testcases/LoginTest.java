package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;

import com.qacart.todo.enums.UserType;
import com.qacart.todo.pages.*;

import com.qacart.todo.utils.RetryAnalyzer;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void ShouldBeAbleToLoginWithEmailAndPassword() throws Exception {

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.login(UserType.CRMUserUAT);
        homePage.checkFromSuccessLogin();
    }



}
