package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;
public class TestBase {
	protected static ApplicationManager app;
	

		@BeforeTest
	public void setUp() throws Exception {
			app=new ApplicationManager();
		
	   
	  }
		public  String generateRandomString(){
			Random rnd=new Random(); 
				return "test"+ rnd.nextInt(7);
		}
		

@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
}
}


	
