package com.assignment.my_assignment_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Hello World!");

		WebDriver driver = new ChromeDriver();
		// 1. open url
		driver.get("http://52.15.183.252:8080/addressbook-2.0/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		// 2. locate new contact button and click

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[2]/div")).click();

		// 3. locate data
		driver.findElement(By.id("gwt-uid-5")).sendKeys("Hetal");
		driver.findElement(By.id("gwt-uid-7")).sendKeys("Patil");
		driver.findElement(By.id("gwt-uid-9")).sendKeys("999999999");
		driver.findElement(By.id("gwt-uid-11")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("gwt-uid-13")).sendKeys("9/12/24,");

		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div[1]/div")).click();
		Thread.sleep(4000);

		/*
		 * driver.getTitle();
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); WebElement
		 * textBox = driver.findElement(By.name("my-text")); WebElement submitButton =
		 * driver.findElement(By.cssSelector("button")); textBox.sendKeys("Selenium");
		 * submitButton.click(); WebElement message =
		 * driver.findElement(By.id("message")); message.getText();
		 * 
		 * WebElement email = driver.findElement(By.id("email")); WebElement password =
		 * driver.findElement(By.id("pass")); WebElement loginButton =
		 * driver.findElement(By.name("login"));
		 * 
		 * Thread.sleep(3000);
		 * 
		 * email.sendKeys("my-project@example.com");
		 * password.sendKeys("my-project-1234");
		 * 
		 * Thread.sleep(3000); loginButton.click(); WebElement afterClick =
		 * driver.findElement(By.xpath(
		 * "/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]"));
		 * 
		 * Thread.sleep(5000);
		 * 
		 * // Check if login was successful (you can check the title or URL)
		 * 
		 * if (afterClick.getText().
		 * contains("The email you entered isn’t connected to an account.")) {
		 * System.out.println("Wrong email!"); }else {
		 * System.out.println("Wrong password!"); }
		 * 
		 * Thread.sleep(3000);
		 */ 
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File("test-report.jpg");

		FileUtils.copyFile(srcFile, destFile);
		driver.quit();
	}
}
