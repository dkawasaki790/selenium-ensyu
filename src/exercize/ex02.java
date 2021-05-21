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
		WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
		driver.get("https://rakuplus.jp/");
			//get()でブラウザ起動 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//処理を停止(動作確認の為) 
		//ブラウザの要素を指定 メソッド名がわかりやすいですよね。
		WebElement userName = driver.findElement(By.id("user_login")); 
		//ユーザー名を入力
		userName.sendKeys("ユーザー名");
		
		WebElement password = driver.findElement(By.id("user_pass")); 
		//パスワードを入力
		password.sendKeys("パスワード");
		//サブミット
		userName.submit();
		
		// ページタイトルが変わるまで待つ。10 秒待っても変わらない場合、
		// org.openqa.selenium.TimeoutException」が発生する。。
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("5兆円おくれ");
			}
		});

		// スクリーンショットを取得し、ファイルを退避する。 ← ← ← ここを追加。
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file.toPath(),new File("ファイルパス" + file.getName()).toPath());
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //ブラウザを閉じる。
		
	}
}
