package StepDefinitions;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import Helper.Controller;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAmazonAccountStepDefinitions {

	WebDriver driver;
	String url1 = "https://www.amazon.fr/";
	String url2 = "https://login.yahoo.com/?.src=ym&pspid=1197806870&activity=header-signin&.lang=fr-FR&.intl=fr&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3Fpspid%3D2023538075%26activity%3Dybar-mail";
	Actions target;

	@Given("^I access to Amazon site$")
	public void i_access_to_amazon_site() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(url1);

		driver.manage().window().maximize();

	}

	@And("^I want to land on a page with a valid title$")
	public void i_land_on_amazon_site() throws Throwable {

		String ActualResult = driver.getTitle();

		String ExpectedReult = "Amazon.fr : livres, DVD, jeux vidéo, musique, high-tech, informatique, jouets, vêtements, chaussures, sport, bricolage, maison, beauté, puériculture, épicerie et plus encore !";

		System.out.println(driver.getTitle());

		Assert.assertEquals(ExpectedReult, ActualResult);

	}

	@And("^I navigate to account creation feature$")
	public void i_navigate_to_account_creation_feature() throws Throwable {

		target = new Actions(driver);

		target.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).perform();

	}

	@And("^I hit on the create account button$")
	public void i_hit_on_the_create_account_button() throws Throwable {

		target.moveToElement(driver.findElement(
				By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Commencer ici.']")))
				.click();

		target.perform();

	}

	@And("^I want to land on the account creation form$")
	public void i_want_to_land_on_the_accunt_creation_form() throws Throwable {

		String ActualResult1 = driver.getTitle();

		String ExpectedReult1 = "Inscription de Amazon";

		Assert.assertEquals(ExpectedReult1, ActualResult1);
	}

	@And("^I fill the required field$")
	public void i_fill_the_required_field() throws Throwable {

		driver.findElement(Controller.NomPrenomID).sendKeys("Skander chakroun");

		driver.findElement(Controller.mailID).sendKeys("chakroun.skander1@yahoo.fr");

		driver.findElement(Controller.PassWordID).sendKeys("ThisIsAPassword123");

		driver.findElement(Controller.ConfPassID).sendKeys("ThisIsAPassword123");

	}

	@When("^I validate the creation of my account$")
	public void i_validate_the_creation_of_my_account() throws Throwable {

		driver.findElement(By.id("continue")).click();
	}

	@Then("^I land on the authentication screen$")
	public void i_land_on_the_authentication_screen() throws Throwable {

		String ActualResult2 = driver.getTitle();

		String ExpectedReult2 = "Veuillez confirmer votre identité";

		Assert.assertEquals(ExpectedReult2, ActualResult2);

	}

	@And("^I want to open a new Tab$")
	public void i_want_to_open_a_new_tab() throws Throwable {

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	@And("^I want to acces to my Email$")
	public void i_want_to_acces_to_my_email() throws Throwable {

		long Start = System.currentTimeMillis();

		driver.get(url2);

		long End = System.currentTimeMillis();

		long Duration = End - Start;

		long Timeout = 5000;

		Assert.assertTrue(Duration < Timeout);

	}

}
