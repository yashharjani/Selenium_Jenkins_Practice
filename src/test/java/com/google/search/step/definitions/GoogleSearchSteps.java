package com.google.search.step.definitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@Given("I am on the {string} url")
	public void openUrl(String urlPath) {
		
		driver.get(urlPath);
		
	}

	@When("I search {string} into the search bar")
	public void searchTheUserInput(String userInput) throws InterruptedException {
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(userInput);
		Thread.sleep(1000);
	}

	@When("I press enter")
	public void pressEnter() throws InterruptedException {
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("I should be navigated to the search options")
	public void i_should_be_navigated_to_the_search_options() {
		String title =driver.findElement(By.cssSelector("h2.PZPZlf[data-attrid='title']")).getText();
		org.testng.Assert.assertEquals("AtliQ Technologies", title);
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
