package com.matthewchiborak.dndcharacterclienttester.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlayingTests {

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
		
		driver.findElement(By.linkText("John Doe")).click();
    }
    
    @Test
    public void creationCreatedCorrectlyTest() {
    	assertEquals("John Doe", driver.findElement(By.id("CharacterNameHeader")).getText());
    	assertEquals("25", driver.findElement(By.id("hpSpinBox")).getAttribute("value"));
    	assertEquals("7", driver.findElement(By.id("hitDieSpinBox")).getAttribute("value"));
    	assertEquals("AC: 16", driver.findElement(By.id("ACSpan")).getText());
    	assertEquals("Speed: 45", driver.findElement(By.id("SpeedSpan")).getText());
    	
    	assertEquals("1", driver.findElement(By.id("spellsSlots1")).getAttribute("value"));
    	assertEquals("2", driver.findElement(By.id("spellsSlots2")).getAttribute("value"));
    	assertEquals("3", driver.findElement(By.id("spellsSlots3")).getAttribute("value"));
    	assertEquals("4", driver.findElement(By.id("spellsSlots4")).getAttribute("value"));
    	assertEquals("5", driver.findElement(By.id("spellsSlots5")).getAttribute("value"));
    	assertEquals("6", driver.findElement(By.id("spellsSlots6")).getAttribute("value"));
    	assertEquals("7", driver.findElement(By.id("spellsSlots7")).getAttribute("value"));
    	assertEquals("8", driver.findElement(By.id("spellsSlots8")).getAttribute("value"));
    	assertEquals("9", driver.findElement(By.id("spellsSlots9")).getAttribute("value"));
    	
    	assertEquals("30", driver.findElement(By.id("counter0")).getAttribute("max"));
    	
    }
    
//    @Test
//    public void testLinks() {
//    	driver.findElement(By.id("Test ReferenceButton")).click();
//    	
//    	while(!isNewWindowPresent()) {
//    		try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//			}
//    	}
//    	
//    	List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
//    	driver.switchTo().window(browserTabs.get(1));
//    	String URL = driver.getCurrentUrl();
//    	assertEquals(URL, "https://www.dndbeyond.com/spells/class/sorcerer");
//    }
//    
//	public boolean isNewWindowPresent() {
//		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
//        return browserTabs.size() > 1;
//	}
    
    @Test
    public void basicRollsTest() {
    	
    	driver.findElement(By.id("InitiativeButton")).click();
    	assertEquals("/r 1d20+3", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("StrengthSaveThrowButton")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("DexteritySaveThrowButton")).click();
    	assertEquals("/r 1d20+3", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("ConstitutionSaveThrowButton")).click();
    	assertEquals("/r 1d20+5", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("IntelligenceSaveThrowButton")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("WisdomSaveThrowButton")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("CharismaSaveThrowButton")).click();
    	assertEquals("/r 1d20+7", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	
    	driver.findElement(By.id("Acrobatics (Dex)Button")).click();
    	assertEquals("/r 1d20+6", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Animal Handling (Wis)Button")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Arcana (Int)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Athletics (Str)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Deception (Cha)Button")).click();
    	assertEquals("/r 1d20+7", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("History (Int)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Insight (Wis)Button")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Intimidation (Cha)Button")).click();
    	assertEquals("/r 1d20+4", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Investigation (Int)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Medicine (Wis)Button")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Nature (Int)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Perception (Wis)Button")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Performance (Cha)Button")).click();
    	assertEquals("/r 1d20+7", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Persuasion (Cha)Button")).click();
    	assertEquals("/r 1d20+7", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Religion (Int)Button")).click();
    	assertEquals("/r 1d20-1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Sleight of Hand (Dex)Button")).click();
    	assertEquals("/r 1d20+3", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Stealth (Dex)Button")).click();
    	assertEquals("/r 1d20+3", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Survival (Wis)Button")).click();
    	assertEquals("/r 1d20+1", driver.findElement(By.id("rollBox")).getAttribute("value"));
    }
    
    @Test
    public void rollPropertyUpdatingRolls() {
    	driver.findElement(By.id("hitDieToUseSpinBox")).clear();
    	driver.findElement(By.id("hitDieToUseSpinBox")).sendKeys("3");
    	driver.findElement(By.id("RollHitDieButton")).click();
    	assertEquals("/r 3d6", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	assertEquals("4", driver.findElement(By.id("hitDieSpinBox")).getAttribute("value"));
    	driver.findElement(By.id("hitDieSpinBox")).clear();
    	driver.findElement(By.id("hitDieSpinBox")).sendKeys("7");
    }
    
    @Test
    public void testCastingASpell() {
    	driver.findElement(By.id("Test AttackButton")).click();
    	assertEquals("4", driver.findElement(By.id("spellsSlots5")).getAttribute("value"));
    	driver.findElement(By.id("spellsSlots5")).clear();
    	driver.findElement(By.id("spellsSlots5")).sendKeys("5");
    	assertEquals("/r 1d20+7\n/r 2d10", driver.findElement(By.id("rollBox")).getAttribute("value"));
    }
    
    @Test
    public void savingStateTest() {
    	driver.findElement(By.id("spellsSlots5")).clear();
    	driver.findElement(By.id("spellsSlots5")).sendKeys("3");
    	driver.findElement(By.id("SaveStateButton")).click();
    	
		while(!isAlertPresent()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Go back")).click();
		driver.findElement(By.linkText("John Doe")).click();
		assertEquals("3", driver.findElement(By.id("spellsSlots5")).getAttribute("value"));
		
    	driver.findElement(By.id("spellsSlots5")).clear();
    	driver.findElement(By.id("spellsSlots5")).sendKeys("5");
    	driver.findElement(By.id("SaveStateButton")).click();
    	
		while(!isAlertPresent()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		driver.switchTo().alert().accept();
		
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
