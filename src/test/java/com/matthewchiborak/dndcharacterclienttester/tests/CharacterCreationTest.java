package com.matthewchiborak.dndcharacterclienttester.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CharacterCreationTest {

	public static WebDriver driver;
	private static boolean setUpIsDone = false;
	
    @Before
    public void init() {
        if (setUpIsDone) {
            return;
        }
        
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumFiles\\selenium-java.3.131.59\\chromdriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
        
        setUpIsDone = true;
    }

    @After
    public void teardown() {
    	
    }
    	
	@Test
	public void loginTest() {
		driver.findElement(By.id("usernameInput")).sendKeys("a");
		driver.findElement(By.id("passwordInput")).sendKeys("a");
		driver.findElement(By.id("loginSubmitButton")).click();
		
		assertEquals("Login", driver.findElement(By.id("LoginHeader")).getText());
		
		driver.findElement(By.id("usernameInput")).sendKeys("admin");
		driver.findElement(By.id("passwordInput")).sendKeys("a");
		driver.findElement(By.id("loginSubmitButton")).click();
		
		assertEquals("Character Select", driver.findElement(By.id("CharacterSelectHeader")).getText());
	}
	
	@Test
	public void switchToCharacterCreation() {
		driver.findElement(By.id("AddNewCharacterLink")).click(); 
		assertEquals("Character Creation", driver.findElement(By.id("CharacterCreationHeader")).getText());
	}
	
	@Test
	public void createACharacterTest() {

		driver.findElement(By.id("nameBox")).clear();
		driver.findElement(By.id("nameBox")).sendKeys("John Doe");
		driver.findElement(By.id("speedBox")).clear();
		driver.findElement(By.id("speedBox")).sendKeys("45");
		driver.findElement(By.id("acBox")).clear();
		driver.findElement(By.id("acBox")).sendKeys("16");
		driver.findElement(By.id("proficiencyBox")).clear();
		driver.findElement(By.id("proficiencyBox")).sendKeys("3");
		driver.findElement(By.id("hpBox")).clear();
		driver.findElement(By.id("hpBox")).sendKeys("25");
		driver.findElement(By.id("strengthScoreBox")).clear();
		driver.findElement(By.id("strengthScoreBox")).sendKeys("8");
		driver.findElement(By.id("dexterityScoreBox")).clear();
		driver.findElement(By.id("dexterityScoreBox")).sendKeys("17");
		driver.findElement(By.id("constitutionScoreBox")).clear();
		driver.findElement(By.id("constitutionScoreBox")).sendKeys("14");
		driver.findElement(By.id("intelligenceScoreBox")).clear();
		driver.findElement(By.id("intelligenceScoreBox")).sendKeys("8");
		driver.findElement(By.id("wisdomScoreBox")).clear();
		driver.findElement(By.id("wisdomScoreBox")).sendKeys("12");
		driver.findElement(By.id("charismaScoreBox")).clear();
		driver.findElement(By.id("charismaScoreBox")).sendKeys("18");
		driver.findElement(By.id("hitDieBox")).clear();
		driver.findElement(By.id("hitDieBox")).sendKeys("7");
		driver.findElement(By.id("hitDieDiceBox")).clear();
		driver.findElement(By.id("hitDieDiceBox")).sendKeys("6");
		
		driver.findElement(By.id("level1SlotsBox")).clear();
		driver.findElement(By.id("level1SlotsBox")).sendKeys("1");
		driver.findElement(By.id("level2SlotsBox")).clear();
		driver.findElement(By.id("level2SlotsBox")).sendKeys("2");
		driver.findElement(By.id("level3SlotsBox")).clear();
		driver.findElement(By.id("level3SlotsBox")).sendKeys("3");
		driver.findElement(By.id("level4SlotsBox")).clear();
		driver.findElement(By.id("level4SlotsBox")).sendKeys("4");
		driver.findElement(By.id("level5SlotsBox")).clear();
		driver.findElement(By.id("level5SlotsBox")).sendKeys("5");
		driver.findElement(By.id("level6SlotsBox")).clear();
		driver.findElement(By.id("level6SlotsBox")).sendKeys("6");
		driver.findElement(By.id("level7SlotsBox")).clear();
		driver.findElement(By.id("level7SlotsBox")).sendKeys("7");
		driver.findElement(By.id("level8SlotsBox")).clear();
		driver.findElement(By.id("level8SlotsBox")).sendKeys("8");
		driver.findElement(By.id("level9SlotsBox")).clear();
		driver.findElement(By.id("level9SlotsBox")).sendKeys("9");
		
		driver.findElement(By.id("constitutionSaveThrowBox")).click();
		driver.findElement(By.id("charismaSaveThrowBox")).click();
		
		driver.findElement(By.id("AcrobaticsSkillBox")).click();
		driver.findElement(By.id("DeceptionSkillBox")).click();
		driver.findElement(By.id("PerformanceSkillBox")).click();
		driver.findElement(By.id("PersuasionSkillBox")).click();
		
		driver.findElement(By.id("attackNameBox")).sendKeys("Test Attack");
		driver.findElement(By.id("attackLevelBox")).clear();
		driver.findElement(By.id("attackLevelBox")).sendKeys("5");
		driver.findElement(By.id("attackRollBox")).clear();
		driver.findElement(By.id("attackRollBox")).sendKeys("/r 1d20+7");
		driver.findElement(By.id("damageRollBox")).clear();
		driver.findElement(By.id("damageRollBox")).sendKeys("/r 2d10");
		driver.findElement(By.id("attackReferenceLinkBox")).sendKeys("https://www.dndbeyond.com/spells/class/sorcerer");
		driver.findElement(By.id("AddAttackButton")).click();
		
		driver.findElement(By.id("counterNameBox")).sendKeys("Test Counter");
		driver.findElement(By.id("counterMaxBox")).clear();
		driver.findElement(By.id("counterMaxBox")).sendKeys("30");
		driver.findElement(By.id("AddCounterButton")).click();
		
		driver.findElement(By.id("referenceNameBox")).sendKeys("Test Reference");
		driver.findElement(By.id("referenceLinkBox")).sendKeys("https://www.dndbeyond.com/spells/class/sorcerer");
		driver.findElement(By.id("AddReferenceButton")).click();
		
		driver.findElement(By.id("SaveNewCharacterButton")).click();
		
		while(!isAlertPresent()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("BackLink")).click();
		
		assertTrue(driver.findElements(By.linkText("John Doe")).size() != 0);
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
