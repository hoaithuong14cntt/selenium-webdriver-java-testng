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

public class Topic_05_Web_Browser_Element_P3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
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
	}
	
	@Test
	public void TC_01_Is_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email Textbox
		WebElement emailTextBox = driver.findElement(By.cssSelector("input#mail"));
		if (emailTextBox.isDisplayed()) {
			emailTextBox.sendKeys("thuong");
			System.out.println("Email is displayed");
		} else {
			System.out.println("Email is not displayed");
		}
		
		//Age under 18 Radio button
		WebElement ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
		if (ageUnder18.isDisplayed()) {
			ageUnder18.click();
			System.out.println("Age Under 18 is displayed");
		} else {
			System.out.println("Age Under 18 is not displayed");
		}
		
		// Education textarea
		WebElement educationTextarea = driver.findElement(By.cssSelector("textarea#edu"));
		if (educationTextarea.isDisplayed()) {
			educationTextarea.sendKeys("ahihi");
			System.out.println("Education is displayed");
		} else {
			System.out.println("Education is not displayed");	
		}
		
		//Image 5 undisplay
		WebElement image5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (image5.isDisplayed()) {
			System.out.println("image5 is displayed");
		} else {
			System.out.println("image5 is not displayed");	
		}
	}
	
	@Test
	public void TC_02_Is_Enabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		if (emailTextbox.isEnabled()) {
			emailTextbox.sendKeys("hoaithuong@gmail.com");
			System.out.println("Email is enable");
		} else {
			System.out.println("Email is not enable");
		}
		
		//Age under 18 Radio button
		WebElement ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
		if (ageUnder18.isEnabled()) {
			ageUnder18.click();
			System.out.println("Age Under 18 is enable");
		} else {
			System.out.println("Age Under 18 is not enable");
		}
		
		// Education textarea
		WebElement educationTextarea = driver.findElement(By.cssSelector("textarea#edu"));
		if (educationTextarea.isEnabled()) {
			educationTextarea.sendKeys("ahihi");
			System.out.println("Education is enable");
		} else {
			System.out.println("Education is not enable");	
		}
		
		// Password input
		WebElement passwordInput = driver.findElement(By.cssSelector("input#disable_password"));
		if (passwordInput.isEnabled()) {
			passwordInput.sendKeys("ahihi");
			System.out.println("Password is enable");
		} else {
			System.out.println("Password is not enable");	
		}
	}
	
	@Test
	public void TC_03_Is_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
		ageUnder18.click();
		if (ageUnder18.isSelected()) {
			System.out.println("ageUnder18 is selected");
		} else {
			System.out.println("ageUnder18 is not selected");	
		}
		
		WebElement javaCheckbox = driver.findElement(By.cssSelector("input#java"));
		javaCheckbox.click();
		if (javaCheckbox.isSelected()) {
			System.out.println("javaCheckbox is selected");
		} else {
			System.out.println("javaCheckbox is not selected");	
		}
	}
	
	@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.cssSelector("input#email")).sendKeys("hoaithuong14cntt@gmail.com");
		sleepInSecond(3);
		
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
		//Check lowercase
		passwordTextbox.sendKeys("aaa");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed' ]")).isDisplayed());
		
		//Check uppercase
		passwordTextbox.clear();
		passwordTextbox.sendKeys("AAA");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed' ]")).isDisplayed());
		
		//Check number-char
		passwordTextbox.clear();
		passwordTextbox.sendKeys("123456");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed' ]")).isDisplayed());
		
		//Check special-char
		passwordTextbox.clear();
		passwordTextbox.sendKeys("!@#$%");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed' ]")).isDisplayed());
		
		//Check 8-char
		passwordTextbox.clear();
		passwordTextbox.sendKeys("hoaithuo");
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed' ]")).isDisplayed());
		
		//Full
		passwordTextbox.clear();
		passwordTextbox.sendKeys("Ht1100@#");
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input.av-password.success-check")).isDisplayed());
		
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
