package exercize;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex01 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
		driver.get("http://www.google.com/xhtml");
			//get()でブラウザ起動 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			//処理を停止(動作確認の為) 
		//ブラウザの要素を指定 メソッド名がわかりやすいですよね。
		WebElement searchBox = driver.findElement(By.name("q")); 
		//検索ボックスで検索
		searchBox.sendKeys("selenium");
		//検索開始
		searchBox.submit();
		//class指定で要素を取得
		String element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).getText().toString();
		
		System.out.println(element);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //ブラウザを閉じる。
		
	}
}
