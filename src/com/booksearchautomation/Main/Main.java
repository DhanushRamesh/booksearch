package com.booksearchautomation.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.booksearchautomation.launch.DriverSetup;
import com.booksearchautomation.locators.Locators;
import com.booksearchautomation.screenshot.Screenshot;

public class Main extends DriverSetup {

	//getting the categories and count from list
	public void categoryandcount() throws Exception 
	{
//		 PrintStream ps_console = System.out;
//
//         File file = new File("file.txt");
//         FileOutputStream fos = new FileOutputStream(file);
//
//         // Create new print stream for file.
//         PrintStream ps = new PrintStream(fos);
//
//         // Set file print stream.
//         System.setOut(ps);
		String a[] = new String[15];
        String b[] = new String[15];
        int j = 0;
        for (int i = 0; i < 15; i++) 
        {
             	j = i + 1;
             	Thread.sleep(500);
				a[i] = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[10]/div[2]/div/div/div/div[" + j + "]/a/p[1]")).getText();
				b[i] = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[10]/div[2]/div/div/div/div[" + j + "]/a/p[2]")).getText();
				System.out.println(a[i]);
				System.out.println(b[i]);
				System.out.println();
				if (i == 5 || i == 11) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"categories_carousel\"]/button[2]")).click();
				}

		}

	}
	
	//Function to browse the list 
	 public void browsetheList() throws Exception
	 {
         try 
         {
        	 WebElement browse=Locators.browseList();
        	 browse.click();
         }
         catch(Exception e) 
         {
             e.printStackTrace();
         }
	 }
	 
	 
	 //Function to open the list
	 public void opentheList() throws Exception 
	 {
		WebElement open = Locators.openList();
		open.click();
     	Thread.sleep(1000);
	 }

	 
	 //Function to select see more link
	public void seemorePage() throws Exception 
	{
		Thread.sleep(2000);
		WebElement seemore = Locators.seemorePage();
		seemore.click();
		Thread.sleep(1000);
		
		//scrolling down to the bottom
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);
	}

	
	//Function to check whether the count is more than 1000
	public static void assert1() throws Exception 
	{
		WebElement count = Locators.countTamil();
		String str = count.getText();
		
		//parsing only the number from the text
		String str1 = str.substring(0, str.length() - 6);
		String str2 = str1.replace(",", "");
		
		//converting the string to integer
		int number = Integer.parseInt(str2);
		int minvalue = 1000;
		if(number>minvalue) {
			System.out.println("Tamil books are more than thousand");
		}
		else if(number<minvalue) {
			System.out.println("Tamil books are less than thousand");
		}
		else {
			System.out.println("There are thousand Tamil books");
		}
	}
	public static void main(String args[]) throws Exception {

		Main obj = new Main();
	    getWebDriver();
		getUrl();
		obj.categoryandcount();
		System.out.println("--------------------------------------------");
		Screenshot.screenShot();
		obj.browsetheList();
		Screenshot.screenShot();
		obj.opentheList();
		Screenshot.screenShot();
		obj.seemorePage();

		 Screenshot.screenShot();

		assert1();
		System.out.println("--------------------------------------------");

		closeBrowser();

	}

}