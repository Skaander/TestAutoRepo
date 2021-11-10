package Helper;

import org.openqa.selenium.By;

public class Controller {

	public static By FindNouveauteBtn() {

		return By.xpath("//a[normalize-space()='Dernières Nouveautés']");
	}

	public static By FindNouveauteBtns = By.xpath("//a[normalize-space()='Dernières Nouveautés']");

	public static By NomPrenomID = By.id("ap_customer_name");

	public static By mailID = By.id("ap_email");

	public static By PassWordID = By.id("ap_password");

	public static By ConfPassID = By.id("ap_password_check");

}
