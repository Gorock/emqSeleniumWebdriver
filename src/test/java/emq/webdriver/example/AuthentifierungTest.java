package emq.webdriver.example;

import org.junit.Assert;
import org.junit.Test;

import emq.webdriver.example.pageobjects.Login;
import emq.webdriver.example.pageobjects.MainPage;
import emq.webdriver.example.pageobjects.Registration;

/**
 * Diese Klasse beinhaltet die Testfälle für die Authentifizierung
 * @author Marc
 *
 */
public class AuthentifierungTest extends AbstractEMQ {

	//  Pageobject for the main page
	MainPage mp = new MainPage(driver);
	
	/*
	 * Temporär deaktiviert, da schon viele Test-Accounts erstellt wurden
	 */
	// @Test
	public void registration() {
		mp.openPage();

		Registration reg = new Registration(driver);
		reg.openPage();
		reg.fillRegistrationForm();
	}

	
	@Test
	public void login() {
		mp.openPage();

		Login login = new Login(driver);
		login.openPage();
		
		/**
		 * Login mit falschen Daten
		 */
		
		login.login("asdf", "aas2fds");
		Assert.assertTrue(login.getDangerAlertMessage().contains("Ungültige Zugangsdaten."));
		
		/**
		 * Login mit richtigen Daten
		 */
		
		login.login("MaxMustermann@discardmail.com", "Max");

		/*
		 * Überprüft ob der Login erfolgreich war in dem der redirekt funktionierte
		 */
		Assert.assertTrue(driver.getCurrentUrl().equals("https://onlinechilishop.de/customer/"));
		
		login.logout();
		
		/*
		 * Überprüft ob der Logout erfolgreich war
		 */
		Assert.assertTrue(driver.getCurrentUrl().equals("https://onlinechilishop.de/login/?logout"));
		Assert.assertTrue(login.getSuccessAlertMessage().contains("Erfolgreich ausgeloggt"));
	}
}
