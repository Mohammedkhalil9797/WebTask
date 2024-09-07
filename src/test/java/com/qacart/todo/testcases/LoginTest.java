package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;

import com.qacart.todo.enums.UserType;
import com.qacart.todo.pages.*;

import com.qacart.todo.utils.ExcelUtils;
import com.qacart.todo.utils.RetryAnalyzer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qacart.todo.enums.UserType.TaskLogin;

public class LoginTest extends BaseTest {


    @DataProvider(name = "excelData")
    public Object[][] dataProviderMethod() throws IOException {
        // Set the Excel file and sheet name
        ExcelUtils.setExcelFile("src/test/java/com/qacart/todo/config/file.xlsx", "Sheet1");
        return ExcelUtils.getExcelData();
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkFromTheSiteUrl() throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.url();


    }

    @Test(retryAnalyzer = RetryAnalyzer.class,dataProvider = "excelData")
    public void checkFromInvalidLogin(String userName,String Password) throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.url();
        loginPage.sendInvalidUsernameAndPassword(userName, Password);
    }



}
