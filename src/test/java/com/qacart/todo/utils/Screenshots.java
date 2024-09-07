package com.qacart.todo.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.model.Media;
import com.qacart.todo.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Screenshots extends BaseTest {
    public static String getScreenShotAsBase64() throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Screenshots/image.png";
        FileUtils.copyFile(source, new File(path));
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            byte[] imageBytes = IOUtils.toByteArray(fileInputStream);
            return Base64.getEncoder().encodeToString(imageBytes);
        }
    }

    public static Media screenShots() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShotAsBase64()).build();
    }

}
