package com.qacart.todo.testcases;
import com.qacart.todo.base.BaseTest;

import com.qacart.todo.pages.LoginPage;

import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword() throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword2() throws IOException, InterruptedException, AWTException {
        LoginPage loginPage = new LoginPage();
        driver.navigate().to("https://imgbb.com/upload");
        loginPage.up();
    }
}
