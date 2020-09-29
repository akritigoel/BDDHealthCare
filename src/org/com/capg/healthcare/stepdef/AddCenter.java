package org.com.capg.healthcare.stepdef;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddCenter {

	WebDriver driver;
	@Given("^I am on the add center page$")
	public void i_am_on_the_add_center_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumsoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/getcenters/addcenter");
		driver.manage().window().maximize();
	}

	@When("^I enter valid centerId and name and address and contactnumber$")
	public void i_enter_valid_centerId_and_name_and_address_and_contactnumber() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("centerId")).sendKeys("maxx");
		driver.findElement(By.id("centerName")).sendKeys("Maxx Diagnostics");
		driver.findElement(By.id("centerAddress")).sendKeys("Mzn, UP");
		driver.findElement(By.id("contactNumber")).sendKeys("8218598007");
		driver.findElement(By.xpath("//button[@class='addcenterbtn']")).click();
	}

	@Then("^message displayed center added successfully$")
	public void message_displayed_center_added_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Alert alert= driver.switchTo().alert();
	   String actual =driver.switchTo().alert().getText();
	   System.out.println(actual);
	   Assert.assertEquals("Center added successfully ", actual);
	   driver.switchTo().alert().accept();
	   driver.close();
	}
	
	
}
