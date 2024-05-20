package com.qacart.todo.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int counter = 0;
    String max_retry_count = ConfigUtils.getInstance().getRetryCount();
    final int maxRetryCount = Integer.parseInt(max_retry_count);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if ((counter < maxRetryCount)) {
            counter++;
            return true;
        }
        return false;
    }
}
