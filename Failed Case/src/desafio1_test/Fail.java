package desafio1_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Fail{

	public static WebDriver driver;
	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		//initialize Firefox driver
		driver = new FirefoxDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		
    	System.out.println("Enter your email id and password to Login");
		driver.findElement(By.id("username")).sendKeys("FAILCASE");
		Thread.sleep(1000);
		
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(1000);
		
	}

	@Then("^Success message shoud be displayed$")
	public void success_message_shoud_be_displayed() throws Throwable {
		driver.findElement(By.className("radius")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		System.out.println("Check Login success message");
		Thread.sleep(2000);
	}
	
	@Then("^IT should be possible to log out$")
	public void it_should_be_possible_to_log_out() throws Throwable {
		driver.findElement(By.className("button secondary radius")).click();
		System.out.println("Log out");
	}
}