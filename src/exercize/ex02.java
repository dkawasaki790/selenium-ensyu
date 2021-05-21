package exercize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ex02 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriver�̍쐬
		driver.get("https://rakuplus.jp/");
			//get()�Ńu���E�U�N�� 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//�������~(����m�F�̈�) 
		//�u���E�U�̗v�f���w�� ���\�b�h�����킩��₷���ł���ˁB
		WebElement userName = driver.findElement(By.id("user_login")); 
		//���[�U�[�������
		userName.sendKeys("���[�U�[��");
		
		WebElement password = driver.findElement(By.id("user_pass")); 
		//�p�X���[�h�����
		password.sendKeys("�p�X���[�h");
		//�T�u�~�b�g
		userName.submit();
		
		// �y�[�W�^�C�g�����ς��܂ő҂B10 �b�҂��Ă��ς��Ȃ��ꍇ�A
		// org.openqa.selenium.TimeoutException�v����������B�B
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("5���~������");
			}
		});

		// �X�N���[���V���b�g���擾���A�t�@�C����ޔ�����B �� �� �� ������ǉ��B
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file.toPath(),new File("�t�@�C���p�X" + file.getName()).toPath());
		}catch (IOException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //�u���E�U�����B
		
	}
}
