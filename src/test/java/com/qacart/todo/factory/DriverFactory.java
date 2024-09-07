package com.qacart.todo.factory;


import com.qacart.todo.utils.ConfigUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;

import java.time.Duration;



public class DriverFactory {

    WebDriver driver;

    public WebDriver initializeDriver() throws MalformedURLException {
        String browser = ConfigUtils.getInstance().getRunner();
        switch (browser) {
            case "CHROME": {
                WebDriverManager.chromedriver().setup();
                WebDriverManager.chromedriver().clearDriverCache().setup();

                ChromeOptions options = new ChromeOptions();

                //  options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);


                break;
            }
            case "FIREFOX": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();


                break;
            }
            case "EDGE": {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("-inprivate");
                driver = new EdgeDriver(edgeOptions);


                break;
            }
            case "SAFARI":
            {
                driver = new SafariDriver();
                break;
            }

            default:
                throw new RuntimeException("this browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

        return driver;
    }
}
