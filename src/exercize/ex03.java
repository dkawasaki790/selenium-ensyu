package exercize;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex03 {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
		driver.get("https://www.e-procurement.metro.tokyo.jp/");
			//get()でブラウザ起動 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        //元のページのハンドルを記憶
		String Handle = driver.getWindowHandle();
		//新しくタブを開くリンク(入札情報サービス)をクリック 
		driver.findElement(By.xpath("//*[@id=\"menu_1\"]/a")).click();

		//次のタブのハンドルを用意し、タブが新しく開かれていたらnewHandleに代入する
		String newHandle = null;
		for (String id : driver.getWindowHandles()) {
		    if(!id.equals(Handle)){
		        newHandle = id;
		    }
		}
		//newHandleにハンドルを移す
		driver.switchTo().window(newHandle);
		
		//発注予定情報をクリック
		driver.findElement(By.xpath("//*[@id=\"topMenuBtn03\"]")).click();
		

		//年
		WebElement requestDateY = driver.findElement(By.name("StartDateYY")); 
		requestDateY.sendKeys("3");
		//月
		WebElement requestDateM = driver.findElement(By.name("StartDateMM")); 
		requestDateM.sendKeys("5");
		//日
		WebElement requestDateD = driver.findElement(By.name("StartDateDD")); 
		requestDateD.sendKeys("21");
		
		//年
		WebElement endDateY = driver.findElement(By.name("EndDateYY")); 
		endDateY.sendKeys("3");
		//月
		WebElement endDateM = driver.findElement(By.name("EndDateMM")); 
		endDateM.sendKeys("6");
		//日
		WebElement endDateD = driver.findElement(By.name("EndDateDD")); 
		endDateD.sendKeys("30");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//検索ボタンを押下し、検索実行
		driver.findElement(By.xpath("/html/body/div[3]/div/form/table[2]/tbody/tr[3]/td/table[2]/tbody/tr/td/a")).click();

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit(); //ブラウザを閉じる。
		
	}
}
