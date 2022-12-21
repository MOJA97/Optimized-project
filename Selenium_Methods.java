package com.OPTIMIZEDseleniumPROJECTONE.com;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Methods {
	public static WebDriver driver;

	public static void screenshot(String path) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
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
		


}
