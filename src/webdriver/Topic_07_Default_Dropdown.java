package webdriver;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String lastName, firstName, employeeID, editLastName, editFirstName, comments;
	Select selectDay;
	Select selectMonth;
	Select selectYear;
	Select selectCountry;
	Random rand;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {//Mac
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");			
		} else {//Windows
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");			
		}
		//Khởi tạo
		driver = new ChromeDriver();
		rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		lastName = "hoai";
		firstName = "thuong";
		employeeID = "";
		editLastName = "";
		editFirstName = "";
		comments = "";
	}
	
	@Test
	public void TC_01_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']")).click();
		sleepInSecond(3);
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("thuong");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Huynh");
		//Khởi tạo select để thao tác với dropdown Day
		selectDay = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		
		//chọn item là 13
		selectDay.selectByVisibleText("13");
		
		//Làm sao biết được chọn 13 được rồi => verify
		Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), "13");
		
		//Khởi tạo select để thao tác với dropdown Month
		selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		
		//chọn item là 13
		selectMonth.selectByVisibleText("May");
		
		//Làm sao biết được chọn 13 được rồi => verify
		Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), "May");
		
		//Khởi tạo select để thao tác với dropdown Year
		selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		
		//chọn item là 13
		selectYear.selectByVisibleText("1965");
		
		//Làm sao biết được chọn 13 được rồi => verify
		Assert.assertEquals(selectYear.getFirstSelectedOption().getText(), "1965");
		int numrand = rand.nextInt(9999);
		driver.findElement(By.cssSelector("input#Email")).sendKeys("hoaithuong14cntt+" + numrand + "@gmail.com");
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Unit");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123123123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123123123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");	
		driver.findElement(By.xpath("//div[@class='header-links']//a[text()='My account']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "thuong");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Huynh");
		selectDay = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), "13");
		Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), "May");
		Assert.assertEquals(selectYear.getFirstSelectedOption().getText(), "1965");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), "hoaithuong14cntt+" + numrand + "@gmail.com");
	}
	
	@Test
	public void TC_02_Default_Dropdown() {
		driver.get("https://rode.com/en/support/where-to-buy");
		selectCountry = new Select(driver.findElement(By.cssSelector("select#country")));
		selectCountry.selectByValue("Vietnam");
		Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(), "Vietnam");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		List<WebElement> dealer = driver.findElements(By.cssSelector("div#map h4"));
		for (WebElement webElement : dealer) {
			System.out.println(webElement.getText());
		}
	}
	

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
