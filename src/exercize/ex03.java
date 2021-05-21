package exercize;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex03 {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriver�̍쐬
		driver.get("https://www.e-procurement.metro.tokyo.jp/");
			//get()�Ńu���E�U�N�� 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        //���̃y�[�W�̃n���h�����L��
		String Handle = driver.getWindowHandle();
		//�V�����^�u���J�������N(���D���T�[�r�X)���N���b�N 
		driver.findElement(By.xpath("//*[@id=\"menu_1\"]/a")).click();

		//���̃^�u�̃n���h����p�ӂ��A�^�u���V�����J����Ă�����newHandle�ɑ������
		String newHandle = null;
		for (String id : driver.getWindowHandles()) {
		    if(!id.equals(Handle)){
		        newHandle = id;
		    }
		}
		//newHandle�Ƀn���h�����ڂ�
		driver.switchTo().window(newHandle);
		
		//�����\������N���b�N
		driver.findElement(By.xpath("//*[@id=\"topMenuBtn03\"]")).click();
		

		//�N
		WebElement requestDateY = driver.findElement(By.name("StartDateYY")); 
		requestDateY.sendKeys("3");
		//��
		WebElement requestDateM = driver.findElement(By.name("StartDateMM")); 
		requestDateM.sendKeys("5");
		//��
		WebElement requestDateD = driver.findElement(By.name("StartDateDD")); 
		requestDateD.sendKeys("21");
		
		//�N
		WebElement endDateY = driver.findElement(By.name("EndDateYY")); 
		endDateY.sendKeys("3");
		//��
		WebElement endDateM = driver.findElement(By.name("EndDateMM")); 
		endDateM.sendKeys("6");
		//��
		WebElement endDateD = driver.findElement(By.name("EndDateDD")); 
		endDateD.sendKeys("30");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//�����{�^�����������A�������s
		driver.findElement(By.xpath("/html/body/div[3]/div/form/table[2]/tbody/tr[3]/td/table[2]/tbody/tr/td/a")).click();

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //�u���E�U�����B
		
	}
}
