package org.com.capg.healthcare.stepdef;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidAdd {

	WebDriver driver;
	@Given("^I am on add center page$")
	public void i_am_on_add_center_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumsoftware\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/getcenters/addcenter");
		driver.manage().window().maximize();
	}

	@When("^I enter existed centerId and name and address and contactnumber$")
	public void i_enter_existed_centerId_and_name_and_address_and_contactnumber() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("centerId")).sendKeys("maxx");
		driver.findElement(By.id("centerName")).sendKeys("Maxx Checkup Labs");
		driver.findElement(By.id("centerAddress")).sendKeys("Lucknow, UP");
		driver.findElement(By.id("contactNumber")).sendKeys("8218597890");
		driver.findElement(By.xpath("//button[@class='addcenterbtn']")).click();
	}

	@Then("^I should see an error message$")
	public void i_should_see_an_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 	WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
			Alert alert= driver.switchTo().alert();
		   String actual =driver.switchTo().alert().getText();
		   System.out.println(actual);
		   Assert.assertEquals("Center with same id exists", actual);
		   driver.switchTo().alert().dismiss();
		   driver.close();
	}
}
