package com.matthewchiborak.dndcharacterclienttester.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatingTest {

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
    public void updatingTest() {
    	driver.findElement(By.linkText("Update")).click();
    	
    	driver.findElement(By.id("nameBox")).clear();
		driver.findElement(By.id("nameBox")).sendKeys("John Doe II");
		driver.findElement(By.id("speedBox")).clear();
		driver.findElement(By.id("speedBox")).sendKeys("450");
		driver.findElement(By.id("acBox")).clear();
		driver.findElement(By.id("acBox")).sendKeys("160");
		driver.findElement(By.id("proficiencyBox")).clear();
		driver.findElement(By.id("proficiencyBox")).sendKeys("4");
		driver.findElement(By.id("hpBox")).clear();
		driver.findElement(By.id("hpBox")).sendKeys("250");
		driver.findElement(By.id("strengthScoreBox")).clear();
		driver.findElement(By.id("strengthScoreBox")).sendKeys("10");
		driver.findElement(By.id("dexterityScoreBox")).clear();
		driver.findElement(By.id("dexterityScoreBox")).sendKeys("10");
		driver.findElement(By.id("constitutionScoreBox")).clear();
		driver.findElement(By.id("constitutionScoreBox")).sendKeys("10");
		driver.findElement(By.id("intelligenceScoreBox")).clear();
		driver.findElement(By.id("intelligenceScoreBox")).sendKeys("10");
		driver.findElement(By.id("wisdomScoreBox")).clear();
		driver.findElement(By.id("wisdomScoreBox")).sendKeys("10");
		driver.findElement(By.id("charismaScoreBox")).clear();
		driver.findElement(By.id("charismaScoreBox")).sendKeys("10");
		driver.findElement(By.id("hitDieBox")).clear();
		driver.findElement(By.id("hitDieBox")).sendKeys("8");
		driver.findElement(By.id("hitDieDiceBox")).clear();
		driver.findElement(By.id("hitDieDiceBox")).sendKeys("7");
		
		driver.findElement(By.id("level1SlotsBox")).clear();
		driver.findElement(By.id("level1SlotsBox")).sendKeys("2");
		driver.findElement(By.id("level2SlotsBox")).clear();
		driver.findElement(By.id("level2SlotsBox")).sendKeys("3");
		driver.findElement(By.id("level3SlotsBox")).clear();
		driver.findElement(By.id("level3SlotsBox")).sendKeys("4");
		driver.findElement(By.id("level4SlotsBox")).clear();
		driver.findElement(By.id("level4SlotsBox")).sendKeys("5");
		driver.findElement(By.id("level5SlotsBox")).clear();
		driver.findElement(By.id("level5SlotsBox")).sendKeys("6");
		driver.findElement(By.id("level6SlotsBox")).clear();
		driver.findElement(By.id("level6SlotsBox")).sendKeys("7");
		driver.findElement(By.id("level7SlotsBox")).clear();
		driver.findElement(By.id("level7SlotsBox")).sendKeys("8");
		driver.findElement(By.id("level8SlotsBox")).clear();
		driver.findElement(By.id("level8SlotsBox")).sendKeys("9");
		driver.findElement(By.id("level9SlotsBox")).clear();
		driver.findElement(By.id("level9SlotsBox")).sendKeys("10");
		
		driver.findElement(By.id("constitutionSaveThrowBox")).click();
		driver.findElement(By.id("charismaSaveThrowBox")).click();
		driver.findElement(By.id("strengthSaveThrowBox")).click();
		driver.findElement(By.id("dexteritySaveThrowBox")).click();
		
		driver.findElement(By.id("AcrobaticsSkillBox")).click();
		driver.findElement(By.id("DeceptionSkillBox")).click();
		driver.findElement(By.id("PerformanceSkillBox")).click();
		driver.findElement(By.id("PersuasionSkillBox")).click();
		driver.findElement(By.id("SurvivalSkillBox")).click();
		
		driver.findElement(By.id("attackNameBox")).sendKeys("Test Attack 2");
		driver.findElement(By.id("attackLevelBox")).clear();
		driver.findElement(By.id("attackLevelBox")).sendKeys("6");
		driver.findElement(By.id("attackRollBox")).clear();
		driver.findElement(By.id("attackRollBox")).sendKeys("/r 1d20+8");
		driver.findElement(By.id("damageRollBox")).clear();
		driver.findElement(By.id("damageRollBox")).sendKeys("/r 3d15");
		driver.findElement(By.id("attackReferenceLinkBox")).sendKeys("https://www.dndbeyond.com/spells/class/sorcerer");
		driver.findElement(By.id("AddAttackButton")).click();
		driver.findElement(By.id("DeleteAttackButton")).click();
		
		driver.findElement(By.id("counterNameBox")).sendKeys("Test Counter 2");
		driver.findElement(By.id("counterMaxBox")).clear();
		driver.findElement(By.id("counterMaxBox")).sendKeys("40");
		driver.findElement(By.id("AddCounterButton")).click();
		driver.findElement(By.id("DeleteCounterButton")).click();
		
		driver.findElement(By.id("referenceNameBox")).sendKeys("Test Reference 2");
		driver.findElement(By.id("referenceLinkBox")).sendKeys("https://www.dndbeyond.com/spells/class/sorcerer");
		driver.findElement(By.id("AddReferenceButton")).click();
		driver.findElement(By.id("DeleteReferenceButton")).click();
		
		driver.findElement(By.id("SaveCharacterButton")).click();
		
		while(!isAlertPresent()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Go back")).click();
		driver.findElement(By.linkText("Go back")).click();
		
		////////////////
		
		driver.findElement(By.linkText("John Doe II")).click();
		
    	assertEquals("John Doe II", driver.findElement(By.id("CharacterNameHeader")).getText());
    	assertEquals("250", driver.findElement(By.id("hpSpinBox")).getAttribute("value"));
    	assertEquals("8", driver.findElement(By.id("hitDieSpinBox")).getAttribute("value"));
    	assertEquals("AC: 160", driver.findElement(By.id("ACSpan")).getText());
    	assertEquals("Speed: 450", driver.findElement(By.id("SpeedSpan")).getText());
    	
    	assertEquals("2", driver.findElement(By.id("spellsSlots1")).getAttribute("value"));
    	assertEquals("3", driver.findElement(By.id("spellsSlots2")).getAttribute("value"));
    	assertEquals("4", driver.findElement(By.id("spellsSlots3")).getAttribute("value"));
    	assertEquals("5", driver.findElement(By.id("spellsSlots4")).getAttribute("value"));
    	assertEquals("6", driver.findElement(By.id("spellsSlots5")).getAttribute("value"));
    	assertEquals("7", driver.findElement(By.id("spellsSlots6")).getAttribute("value"));
    	assertEquals("8", driver.findElement(By.id("spellsSlots7")).getAttribute("value"));
    	assertEquals("9", driver.findElement(By.id("spellsSlots8")).getAttribute("value"));
    	assertEquals("10", driver.findElement(By.id("spellsSlots9")).getAttribute("value"));
    	
    	assertEquals("40", driver.findElement(By.id("counter0")).getAttribute("max"));
		
    	driver.findElement(By.id("InitiativeButton")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("StrengthSaveThrowButton")).click();
    	assertEquals("/r 1d20+4", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("DexteritySaveThrowButton")).click();
    	assertEquals("/r 1d20+4", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("ConstitutionSaveThrowButton")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("IntelligenceSaveThrowButton")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("WisdomSaveThrowButton")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("CharismaSaveThrowButton")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	
    	driver.findElement(By.id("Acrobatics (Dex)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Animal Handling (Wis)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Arcana (Int)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Athletics (Str)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Deception (Cha)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("History (Int)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Insight (Wis)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Intimidation (Cha)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Investigation (Int)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Medicine (Wis)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Nature (Int)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Perception (Wis)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Performance (Cha)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Persuasion (Cha)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Religion (Int)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Sleight of Hand (Dex)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Stealth (Dex)Button")).click();
    	assertEquals("/r 1d20", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	driver.findElement(By.id("Survival (Wis)Button")).click();
    	assertEquals("/r 1d20+4", driver.findElement(By.id("rollBox")).getAttribute("value"));
    	
    	
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
