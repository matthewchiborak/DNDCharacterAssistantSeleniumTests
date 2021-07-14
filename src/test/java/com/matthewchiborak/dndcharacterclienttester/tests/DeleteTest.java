package com.matthewchiborak.dndcharacterclienttester.tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteTest {
	public static WebDriver driver;
	private static boolean setUpIsDone = false;
	
    @Before
    public void init() {
        if (setUpIsDone) {
            return;
        }
        
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumFiles\\selenium-java.3.131.59\\chromdriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
        
        setUpIsDone = true;
        
		driver.findElement(By.id("usernameInput")).sendKeys("admin");
		driver.findElement(By.id("passwordInput")).sendKeys("a");
		driver.findElement(By.id("loginSubmitButton")).click();
		
		driver.findElement(By.linkText("John Doe II")).click();
    }
    
    @Test
    public void deleteTest() {
    	driver.findElement(By.linkText("Update")).click();
    	driver.findElement(By.id("DeleteCharacterButton")).click();
    	
		while(!isAlertPresent()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Go back")).click();
		driver.findElement(By.linkText("Go back")).click();
		
		assertTrue(driver.findElements(By.linkText("John Doe II")).size() == 0);
    }
    
	public boolean isAlertPresent() {
		try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }  
	}
}
