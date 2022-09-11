package javaTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		//Thông tin của một nhân viên
		//Tên,tuổi,dob,giới tính, quê quán, lương
		//Ánh xạ thông tin này vào lập trình
		//Cách khai báo biến
		//1. Kiểu dữ liệu của biến
		//2. Tên biến
		//3. Giá trị của biến
		
		//2 cách khai báo và gán giá trị
		//1. Vừa khai báo vừa gán trực tiếp
		String name = "Automation Testing";
		//2. Khai báo trước rồi gán sau
		String name1;
		name1 = "Automation Testing 1";
		//2 loại kiểu dữ liệu
		//I. Kiểu dữ liệu nguyên thủy
		//8 loại
		//Số nguyên: byte, short, int, long
		byte bNumber = 5;
		short sNumber = 500;
		int iNumber = 6000;
		long lNumber = 123456789;
		//Số thực: float, double (Có phần thập phân)
		float fNumber = 15.5f;
		double dNumber = 9.8d;
		//Kí tự: char
		char a = 'a';
		//Logic: Boolean
		boolean marriedStatus = false;
		//Kiểu dữ liệu tham chiếu
		//Chuỗi: string
		String emailValid = "hoaithuong14cntt@gmail.com";
		//Class/Interface
		Date date = new Date();
		WebDriver driver = new FirefoxDriver();
		//Object
		Object students;
		//Array => cố định
		int numbers[] = {5, 10, 15};
		String address[] = {"DaNang", "HaNoi", "HCM"};
		//List/Set/Queue(Collection) => động
		List<Integer> studentNumber = new ArrayList<Integer>();
		List<String> studentAddress = new ArrayList<String>();
		//Set
		LinkedHashSet<String> studentCity = new LinkedHashSet<String>();

	}

}
