package exercize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriver�̍쐬
		driver.get("http://www.google.com/xhtml");
			//get()�Ńu���E�U�N�� 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			//�������~(����m�F�̈�) 
		//�u���E�U�̗v�f���w�� ���\�b�h�����킩��₷���ł���ˁB
		WebElement searchBox = driver.findElement(By.name("q")); 
		//�����{�b�N�X�Ō���
		searchBox.sendKeys("selenium");
		//�����J�n
		searchBox.submit();
		//class�w��ŗv�f���擾
		String element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).getText().toString();
		
		System.out.println(element);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //�u���E�U�����B
		
	}
}
