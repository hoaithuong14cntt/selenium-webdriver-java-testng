package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_Textarea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String lastName, firstName, employeeID, editLastName, editFirstName, comments;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {//Mac
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");			
		} else {//Windows
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");			
		}
		//Khởi tạo
		driver = new ChromeDriver();
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
	public void TC_01_Textbox_Textarea() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
		sleepInSecond(5);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
		System.out.println(employeeID);
		sleepInSecond(10);
		driver.findElement(By.xpath("//button[contains(string(), 'Save')]")).click();
		sleepInSecond(5);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeID);
		sleepInSecond(5);
		//Hàm clear() đang lỗi
		driver.findElement(By.xpath("//input[@name='firstName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
//		sleepInSecond(5);
//		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("thuong 1 nef");
//		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Ahihi doof ngok");
//		driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[contains(string(),'Save')]")).click();
//		sleepInSecond(5);
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), "thuong 1 nef");
//		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), "Ahihi doof ngok");
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		driver.findElement(By.xpath("//div[@class='orangehrm-action-header']//button")).click();
		comments = "Huynh\nthi hoai thuong\n ne ahihi\n do ngok      \n   dang lamf ig do";
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(comments);
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys("1234");
		driver.findElement(By.xpath("//form[@class='oxd-form']//button[@type='submit']"));
		String textareaNewValue = driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value");
		Assert.assertEquals(textareaNewValue, comments);
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
