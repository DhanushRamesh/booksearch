package com.booksearchautomation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.booksearchautomation.launch.DriverSetup;
public class Locators extends DriverSetup {

                public Locators() throws Exception{

                                super();

                }

                //locator to browse the list 
                public static WebElement browseList() {

                                WebElement browse=driver.findElement(By.xpath("//*[@id=\"header-bar\"]/ul[1]/li[1]"));

                                return browse;

                }

              //locator to open the list 
                public static WebElement openList() {

                                WebElement open=driver.findElement(By.xpath("//*[@id=\'header-bar\']/ul[1]/li[1]/div/details/div/ul/li[1]/a"));

                                return open;

                }

              //locator to press the seemore link 
                public static WebElement seemorePage() {

                                WebElement seemore=driver.findElement(By.xpath("//*[@id=\'subjectsPage\']/ul[13]/li[9]/a"));

                                return seemore;

                }

              //locator to select the language 
                public static WebElement selectLan() {

                                WebElement select=driver.findElement(By.xpath("//*[@id=\'contentBody\']/ul/li[38]/a"));

                                return select;

                }

              //locator to locate the number of tamil books
                public static WebElement countTamil() {

                                WebElement count=driver.findElement(By.xpath("//*[@id=\'contentBody\']/ul/li[38]/span/b"));

                                return count;

                }

 

}