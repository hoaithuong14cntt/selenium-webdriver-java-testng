package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	WebElement element;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {//Mac
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");			
		} else {//Windows
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");			
		}
		//Khởi tạo
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Browser() {
		//Các hàm tương tác với browser sẽ thông qua các biến driver
		//Đóng browser (Đóng tab hiện tại)
		driver.close(); 
		//Đóng browser (ĐÓng cả browser)
		driver.quit();
		//TÌm ra 1 element 
		WebElement loginButton = driver.findElement(By.cssSelector(""));
		//Tìm ra nhiều hơn 1 element
		List<WebElement> links = driver.findElements(By.cssSelector(""));
		//Mở ra cái url được truyền vào
		driver.get("https://www.facebook.com/");
		//Trả về 1 url tại page đang đứng
		String gameUrl = driver.getCurrentUrl();
		String gameTitle = driver.getTitle();
		
		//Trả về source code của page hiện tại
		String gamePageSourceCode = driver.getPageSource();
		
		//Lấy ra cái ID của cái tab/windown đang đứng
		driver.getWindowHandle();//1
		driver.getWindowHandles();// Tất cả các tab
		driver.manage().getCookies();//Cookies
		driver.manage().logs().getAvailableLogTypes(); //Log
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		//Test GUI(Giao diện)
		//Font/size/Color/Position/....
		//Ưu tiên chức nắng trước
		//Chờ cho element dc tìm thấy trong khoản thời gian xx giây
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Chờ cho page load thành công sau XX giây
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//Chờ cho script dc inject thành công sau xx giây
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.navigate().to("https://www.facebook.com/");
		
		//Alert/ Frame(IFrame)/ Windown (Tab)
		driver.switchTo().alert();
		driver.switchTo().frame(0);
		driver.switchTo().window("");
	}

	@Test
	public void TC_02_Element() {
		driver.get("https://www.facebook.com/");
		//Các hàm tương tác với element sẽ thông qua các biến element
//		element.
		//2 cách để mình thao tác
		//Khai báo biên và dùng lại
		//Dùng đi dùng lại nhiều lần - ít nhất 2 lần thì mới cần khai báo biến
		
		//Khai báo biên cùng với kiểu dữ liệu trả về của hàm findElement
		WebElement emailAddressTextbox = driver.findElement(By.id("email"));
		emailAddressTextbox.clear();
		emailAddressTextbox.sendKeys("dam@gmail.com");
		
		//Xóa dữ liệu trong một field dạn editable(có thể nhập)
		//Textbox/Textarea/editable dropdown
		element.clear();
		
		//Nhập dữ liệu vào field dang editable
		element.sendKeys("abc");
		element.sendKeys(Keys.ENTER);
		
		//Trả về giá trị nằm trong attribute đó
		element.getAttribute("placeholder");
		
		driver.findElement(By.id("firstname")).getAttribute("value");
		
		//Trả về thuộc tính css của element này
		//Trả về màu nền của element này
		element.getCssValue("background-color");
		
		//Visualing testing
		element.getLocation();
		element.getRect();
		
		//Chụp hình và attach vapf html report
		element.getScreenshotAs(OutputType.FILE);
		
		// Trả về thẻ HTML 
		element.getTagName();
		
		//Trả về text của một element (Links/Header/Message Lỗi)
		element.getText();
		
		//Trả về đúng/sai của 1 element có hiển thị hoặc không
		element.isDisplayed();
		
		//Có bị disable hay không
		element.isEnabled();
		
		//có được chọn hay không (Checkbox/radio)
		element.isSelected();
		
		//Dropdown: có 1 thư viện riêng để xử lí (Select)
		//Chỉ làm việc được với form
		element.submit();
		
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}