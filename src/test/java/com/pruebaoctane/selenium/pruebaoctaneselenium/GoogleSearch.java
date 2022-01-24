package com.pruebaoctane.selenium.pruebaoctaneselenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;

public class GoogleSearch {
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		//driver.execute_script("replace.window.location{"www.Url2.com"}");
	}
	@Test
	public void testGooglePage(){
 		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("Hexaware");
		searchBox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals("Hexaware - Buscar con Google", driver.getTitle());
	}
	@After
	public void tearDown(){
		driver.quit();
	}
}
