package com.booksearchautomation.screenshot;

import java.io.File;

import java.io.IOException;

//import java.util.logging.FileHandler;

 

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

 

import com.booksearchautomation.launch.DriverSetup;

//import org.apache.commons.io.FileUtils;

 

public class Screenshot extends DriverSetup {

                public static  int i=0;

                public static void screenShot() throws IOException{

                                TakesScreenshot scrShot=(TakesScreenshot)driver;

                                File Src=scrShot.getScreenshotAs(OutputType.FILE);
                                
                                //providing the path to store the screenshot
                                String filePath= System.getProperty("user.dir")+"//screenshots//Screenshot"+i+".png";

                                i++;

                                File Dest=new File(filePath);

                                FileHandler.copy(Src,Dest);

                               

                               

                }

 

}