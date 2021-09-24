package com.booksearchautomation.launch;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {

	public static WebDriver driver;

	// To invoke the browser
	public static WebDriver getWebDriver() {
		String newline = System.lineSeparator();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the desired Browser :" + newline + "i)Chrome" + newline + "ii)Firefox");

		// getting the user input as string
		String userinput = sc.next();

		// converting the string to lowercase
		String browser = userinput.toLowerCase();

		// invoking the browser based on choice
		if (browser.equalsIgnoreCase("chrome")) {

			
			//setup for chrome driver
			System.setProperty("webdriver.chrome.driver",
					"D:\\Java Workspace\\SecondSelenium\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-disable-notifications");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			
			//setup for firefox driver
			System.setProperty("webdriver.gecko.driver",
					"D:\\Java Workspace\\SecondSelenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		//invalid browser condition
		else {
			System.out.println("Invalid Browser Choice!");
		}

		return driver;
	}

	// getiing the url
	public static void getUrl() throws Exception {

		//Getting the location of the url from properties file
		String filelocation = "D:\\Java Workspace\\BookSearchAutomation\\Url";

		File file = new File(filelocation);

		FileInputStream fileinput = new FileInputStream(file);

		Properties prop = new Properties();

		prop.load(fileinput);

		// maximizing the window
		driver.manage().window().maximize();

		// getting the url from file
		driver.get(prop.getProperty("url"));

		//deleting the cookies of browser
		driver.manage().deleteAllCookies();

		//making a implicit wait of 3o seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// function to close the browser
	public static void closeBrowser() {

		driver.quit();

	}

}
