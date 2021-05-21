package exercize;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex03 {
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriverを起動
		driver.get("https://www.e-procurement.metro.tokyo.jp/");
			//get()で起動
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        //今現在のハンドルを覚える
		String Handle = driver.getWindowHandle();
		//新しくタブ（入札情報システム）を開く
		driver.findElement(By.xpath("//*[@id=\"menu_1\"]/a")).click();

		//タブが異なっていたらidをセット
		String newHandle = null;
		for (String id : driver.getWindowHandles()) {
		    if(!id.equals(Handle)){
		        newHandle = id;
		    }
		}
		//newHandleに切り替える
		driver.switchTo().window(newHandle);
		
		//クリック
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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//検索実行
		driver.findElement(By.xpath("/html/body/div[3]/div/form/table[2]/tbody/tr[3]/td/table[2]/tbody/tr/td/a")).click();
		
		//WebElementをリストで取得
		List<WebElement> elements =  
				driver.findElements(By.xpath("/html/body/div[3]/div/form/table[5]"));
		System.out.println("Number of elements:" +elements.size());
		
		for(ListIterator<WebElement>iterator = elements.listIterator(); iterator.hasNext();){

		    System.out.println(iterator.next().getText()+"	");
		}
		
		
		
	}
}
