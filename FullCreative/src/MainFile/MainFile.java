package MainFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MainFile{

	static WebDriver driver;
	public static void main(String[] args) throws Exception {

		setBrowser();
		launchUrl();
		drawlines();
		verticalLine();
		drawRectangle();
		useEraser();
		quitDriver();

	}
	/*
	 * Method to launch canvas studio
	 *  */
	
	public static void launchUrl() {

		driver.get("http://www.htmlcanvasstudio.com/");
	}
	
	/*
	 * Method to quit the chrome driver
	 * */

	public static void quitDriver() {
		driver.quit();
	}

	/*
	 * Method to set the chrome browser
	 * */
	
	public static void setBrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/sahiljain04/Desktop/chromedriver");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	/*
	 * Method to use the eraser and to erase the horizontal line
	 */
	
	public static void useEraser() {

		WebElement element1 = driver.findElement(By.id("container"));
		WebElement erase =  driver.findElement(By.cssSelector(".button.eraser"));

		Actions action = new Actions(driver);  

		erase.click();
		element1.click();

		action.clickAndHold(erase).dragAndDropBy(element1, 100,0).build().perform();

	}

	/*
	 * Method to draw a rectangle*/
	
	public static void drawRectangle() {

		WebElement line =  driver.findElement(By.cssSelector(".button.line"));
		WebElement element1 = driver.findElement(By.id("container"));
		WebElement rect = driver.findElement(By.cssSelector(".button.rectangle"));
		Actions action = new Actions(driver);  


		rect.click();
		element1.click();

		action.clickAndHold(rect).dragAndDropBy(element1, -20, 0);

		action.moveByOffset(40,100).click().build().perform();
		action.moveByOffset(70,70).click().build().perform();

		line.click();

	}
	
	/*
	 * Method to draw the horizontal lines
	 * */
		
	public static void drawlines() {

		WebElement element1 = driver.findElement(By.id("container"));
		WebElement line =  driver.findElement(By.cssSelector(".button.line"));
		Actions action = new Actions(driver);  

		line.click();
		element1.click();

		action.clickAndHold(line).moveToElement(element1,70,90).build().perform();
		action.moveToElement(element1,100,0).click().build().perform();

		action.moveByOffset(-50,0).click();
		action.moveByOffset(0,-50).click().build().perform();
	}

	/*
	 * Method to draw the vetical line
	 * */
	
	public static void verticalLine() {

		WebElement element1 = driver.findElement(By.id("container"));
		Actions action = new Actions(driver);  
		WebElement line =  driver.findElement(By.cssSelector(".button.line"));

		line.click();
		//element1.click();

		action.moveByOffset(0,0).click();
		action.moveByOffset(0,90).click().build().perform();	
	}
}
