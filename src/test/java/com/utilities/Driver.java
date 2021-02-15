package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {

    }

   public static WebDriver getDriver(){

        if(driver == null){
            String browser = ConfigurationReader.getProperties("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                    break;
                default:

                    WebDriverManager.edgedriver().setup();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);


            }

        }

        return driver;

   }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }



}
