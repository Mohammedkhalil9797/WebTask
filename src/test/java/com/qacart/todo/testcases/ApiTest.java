package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.ApiRegister;
import com.qacart.todo.utils.RetryAnalyzer;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void apiGetStatus() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.getStatus();


    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void apiGetListOfBock() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.getListOfBock();


    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void apiGetSingleBock() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.getSingleBock();


    }
    /*
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Auth() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.auth();


    }*/
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void postOrder() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.submitOrder();


    }
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void getAllOrder() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.getAllOrder();


    }
    @Test(priority = 3,retryAnalyzer = RetryAnalyzer.class)
    public void deleteOrder() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.deleteOrder();


    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void updateOrder() throws Exception {

        ApiRegister apiRegister = new ApiRegister();
        apiRegister.updateOrder();


    }
}
