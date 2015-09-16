package com.usaa.MiddleEarth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenUserBrowsesAWebPage {
    
    @Test
    public void servletShouldRespond() {
    	System.setProperty("webdriver.chrome.driver","C:/Users/plk6272/oss/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/MiddleEarth/board.html");
        driver.manage().window().maximize();
        String str = driver.getCurrentUrl();
        System.out.println("The current URL is " + str);
        if(str.length() < 0) {
        	fail("Page Didn't respond");
        }
        driver.close();
    }
    
    @Test
    public void servletShouldRespondEvenIfInLoop() {
    	BoardStatusServlet servlet = new BoardStatusServlet();
    	
    }
}