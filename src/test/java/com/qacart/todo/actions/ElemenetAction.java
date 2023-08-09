package com.qacart.todo.actions;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.utils.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class ElemenetAction extends BaseTest {
     static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static WebElement element(final By by) {
        return driver.findElement(by);
    }
    public static void sendKeys(By locator, String text) throws Exception {
        WebElement wElement = element(locator);
        if (wElement != null) {
            wElement.sendKeys(text);
            jse.executeScript("arguments[0].style.border='3px solid green'",wElement);
            logger.info("The User Enter value  in  " +wElement.getText()+" and The Value Equal  "+ text, Screenshots.screenShots());

        } else
            throw new Exception("Can't find the Element, Locator: " + locator.toString());

    }
        public static void click(By by) throws IOException {
            logger.info("User Clicks on " + element(by).getText(), Screenshots.screenShots());
            element(by).click();

        }
    public static void clickAction(By by) {
        try {
            jse.executeScript("arguments[0].style.border='3px solid green'", element(by));
            logger.info("User Clicks on " + element(by).getText(), Screenshots.screenShots());
            Actions action = new Actions(driver);
            action.click(element(by)).build().perform();

            // highlight the element with green border 3px width

            // added sleep to give little time for browser to respond
           // logger.info("User Clicks on " + element(by).getText(), Screenshots.screenShots());
        } catch (Exception ex) {
            jse.executeScript("arguments[0].style.border='3px solid red'", element(by));

        }
    }
    public static void uploadFiles(By by,String location) throws InterruptedException, AWTException {
        Robot robot=new Robot();
        StringSelection s = new StringSelection(location);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
        element(by).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
    }
    public static void navigate(String url) throws IOException {
        driver.navigate().to(url);
        logger.info("Navigation to Page with URL : " + url, Screenshots.screenShots());

    }    public static void scrollTo(By by) throws IOException {

        jse.executeScript("arguments[0].scrollIntoView(true);", element(by));
        jse.executeScript("arguments[0].style.border='3px solid green'", element(by));
        // added sleep to give little time for browser to respond
        logger.info("User Scroll To " + element(by).getText(), Screenshots.screenShots());
    }
    public static String getUrl() throws IOException {

        // added sleep to give little time for browser to respond
        logger.info("User Get Current Url  " , Screenshots.screenShots());
    return driver.getCurrentUrl();
    }
    public static String getText(By by) throws IOException {
        jse.executeScript("arguments[0].style.border='3px solid green'", element(by));
        // added sleep to give little time for browser to respond
        logger.info("User Get text From element  "+element(by).getText() , Screenshots.screenShots());
      return  element(by).getText();

    }

}
