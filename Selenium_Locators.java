package com.OPTIMIZEDseleniumPROJECTONE.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Locators{

	public static WebDriver driver;
	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Screenshots\\"+path+".png");
		FileUtils.copyFile(source, destination);

	}

	public static void click(WebElement element) {

		element.click();
	}

	public static void clear(WebElement element) {

		element.clear();
	}

	public static void implicitly_Wait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public static void get_Title() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void dropdown_Index(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void dropdown_Value(WebElement element, String name) {

		Select s = new Select(element);
		s.selectByValue(name);
	}

	public static void dropdown_Text(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void send_Values(WebElement element, String Values) {

		element.sendKeys(Values);
	}

	public static void pageLoadout_TimeDuration() {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));

	}
	public static void right_Click(WebElement element) {

		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();

	}
	public static void down_Enter() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws InterruptedException, IOException, AWTException{
		// browser launched
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Javed\\eclipse-workspace\\Selenium_Automation_Tool\\Driver\\chromedriver.exe");
		// Incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Incognito");
		// Upcasting
		driver = new ChromeDriver(options);
		// WebDriver methods
		driver.get("https://adactinhotelapp.com/");
		// Implicitly wait
		driver.manage().window().maximize();
		
		// Register and Login
		WebElement register = driver.findElement(By.xpath("//a[text()='New User Register Here']"));
		click(register);
		// register
		Thread.sleep(8000);
		// I used thread for 6 seconds to hold up the loading page to fill the captcha
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		send_Values(username, "JavedMo7");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		send_Values(password, "JAVED987654!");
		
		WebElement Re_enter_password = driver.findElement(By.xpath("//input[@id='re_password']"));
		send_Values(Re_enter_password, "JAVED987654!");
		
		WebElement name = driver.findElement(By.xpath("//input[@name='full_name']"));
		send_Values(name, "Mohammed Javed");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email_add']"));
		send_Values(email, "itsmemojaved@gmail.com");

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		click(checkbox);
		// here I used thread because Captcha cant be done by selenium
		// manually I entered the displayed captcha
		
		screenshot("register page");
		System.out.println("Register page screenshot");
		
		WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Register']"));
		click(registerBtn);
		
		WebElement login = driver.findElement(By.xpath("//a[.='Click here to login']"));
		click(login);
		
		WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
		send_Values(Username, "JavedMo7");
		
		WebElement Loginpassword = driver.findElement(By.xpath("//input[@id='password']"));
		send_Values(Loginpassword, "JAVED987654!");
		
		Thread.sleep(14000);
		//I am going to verify my email Id Thats why I use here thread for 20 seconds

		screenshot("login page");
		System.out.println("Login page screenshot taken");
		
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='Submit']"));
		click(loginbtn);
		
		WebElement Location = driver.findElement(By.xpath("//select[@id='location']"));
		click(Location);
		dropdown_Value(Location, "New York");
		
		WebElement hotel = driver.findElement(By.xpath("//select[@id='hotels']"));
		click(hotel);
		dropdown_Value(hotel, "Hotel Hervey");
		
		WebElement roomtype = driver.findElement(By.xpath("//select[@name='room_type']"));
		click(roomtype);
		dropdown_Text(roomtype, "Super Deluxe");
		
		WebElement numberofRooms = driver.findElement(By.xpath("//select[@name='room_nos']"));
		click(numberofRooms);
		dropdown_Value(numberofRooms, "2");
		
		WebElement checkin = driver.findElement(By.xpath("//input[@name='datepick_in']"));
		clear(checkin);
		send_Values(checkin, "30/11/2022");
		
		WebElement checkout = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		clear(checkout);
		send_Values(checkout, "02/12/2022");
		
		WebElement adults = driver.findElement(By.xpath("//select[@name='adult_room']"));
		click(adults);
		dropdown_Value(adults, "2");
		
		WebElement children = driver.findElement(By.xpath("//select[@name='child_room']"));
		click(children);
		dropdown_Text(children, "4 - Four");

		screenshot("Booking details page");
		System.out.println("Booking page screenshot done");
		Thread.sleep(5000);
		WebElement submit_btn = driver.findElement(By.xpath("//input[contains(@id,'Submit')]"));
		click(submit_btn);
		
		WebElement radiobtn = driver.findElement(By.xpath("//input[@type='radio']"));
		click(radiobtn);
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		click(continueBtn);
		
		WebElement firstname = driver.findElement(By.xpath("//input[contains(@name,'first_name')]"));
		send_Values(firstname, "Mohammed");
		
		WebElement lastname = driver.findElement(By.xpath("//input[@id='last_name']"));
		send_Values(lastname, "Javed");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@name='address']"));
		send_Values(address, "NO 6 Vivenkandar Theru, Dubai kuruku sandhu, dubai main road dubai");
		
		WebElement creditcardNO = driver.findElement(By.xpath("//input[@id='cc_num']"));
		send_Values(creditcardNO, "2039480123812325");
		
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='cc_type']"));
		click(CCtype);
		dropdown_Text(CCtype, "VISA");
		
		WebElement CCexpirydatefrom = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		click(CCexpirydatefrom);
		dropdown_Value(CCexpirydatefrom, "12");
		
		WebElement CCEXPyear = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		click(CCEXPyear);
		dropdown_Text(CCEXPyear, "2022");
		
		WebElement cvv = driver.findElement(By.xpath("//input[@name='cc_cvv']"));
		send_Values(cvv, "940");
		
		Thread.sleep(3000);
		screenshot("billing receipt page");
		System.out.println("Billing receipt page screenshot");
		
		WebElement booknow = driver.findElement(By.xpath("//input[@name='book_now']"));
		click(booknow);
		
		WebElement bookitenary = driver.findElement(By.xpath("//a[contains(text(),'Booked Itinerary')]"));
		click(bookitenary);

		WebElement checkboxcancel = driver.findElement(By.xpath("//input[@type='checkbox']"));
		click(checkboxcancel);
		
		WebElement cancelBooking = driver.findElement(By.xpath("//input[@name='cancelall']"));
		click(cancelBooking);
		
		
		driver.switchTo().alert().accept();
		
		screenshot("Cancel booking page");
		System.out.println("Booking cancel page and alert screenshot");
		
		WebElement logout = driver.findElement(By.xpath("//input[@name='logout']"));
		click(logout);
		
		WebElement loginagain = driver.findElement(By.xpath("//a[.='Click here to login again']"));
		right_Click(loginagain);
		down_Enter();
		Thread.sleep(3000);

		WebElement download = driver.findElement(By.xpath("(//a[text()='DOWNLOAD'])[1]"));
		right_Click(download);
		down_Enter();

		String current_ID = driver.getWindowHandle();
		System.out.println("Current_ID:" + current_ID);

		String Url = "https://adactinhotelapp.com/resources/AdactinHotelApp_SetupGuide.pdf";
		Set<String> all_ID = driver.getWindowHandles();
		// set- doesnt allow the duplicate value and it is unique
		for (String eachID : all_ID) {

			if (driver.switchTo().window(eachID).equals(Url)) {

				break;

			}
		}

		get_Title();
		screenshot("Current Page");
		System.out.println("Current page Screenshot");
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		

	}

}
