package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class SeleniumDemo {

    private static WebDriver driver = null;

   @Test
    public  void initDriver() throws Exception {

       System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");

       driver = new FirefoxDriver();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       Path sampleFile = Paths.get("src/main/resources/uploadDemo.html");
       driver.get(sampleFile.toUri().toString());

      // driver.get("file:///src/main/resources/uploadDemo.html");

       //driver.get();

     // driver.get("file://src/main/resources/uploadDemo.html");

       WebElement element=driver.findElement(By.xpath("//input[@type='file']"));

       JavascriptExecutor executor = (JavascriptExecutor)driver;
       executor.executeScript("arguments[0].click();", element);


       Thread.sleep(5000);

       Runtime.getRuntime().exec("src/main/resources/scriptAutoIT.exe");

       Thread.sleep(5000);

       driver.quit();
   }
}
