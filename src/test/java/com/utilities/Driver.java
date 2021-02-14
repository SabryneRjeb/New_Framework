package com.utilities;

import com.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {}

    private static WebDriver driver;

    public static WebDriver getDriver() {

        // This null pointer here works as tracker, it will basically keep track of the same instance of
        // the driver at the time of execution and will prevent repeated steps.
        if (driver == null) {

            // This method is calling the static method of getProperty in the ConfigurationReader Class.
            // The return type is String so I can assign it to a String to re-use.
            String browser = ConfigurationReader.getProperty("browser");

            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("internetExplorer")) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("opera")) {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                System.out.println("Un-identified Browser in configuration.properties");
                return null;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
