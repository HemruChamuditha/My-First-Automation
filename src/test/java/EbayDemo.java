import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EbayDemo {

    public static void main(String[] args) throws InterruptedException {

        //create() method initializes a new ChromeDriver instance, which opens a new Chrome browser window.
        //WebDriver is an interface in Selenium that provides methods for interacting with web browsers, such as navigating to URLs, interacting with web elements, and controlling browser behavior.
        WebDriver driver = WebDriverManager.chromedriver().create();
//        System.out.println(driver.getClass()); --> class org.openqa.selenium.chrome.ChromeDriver
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//input[@id='gh-ac']")).click();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Iphone");

        Select selectCategory = new Select(driver.findElement(By.id("gh-cat")));
        selectCategory.selectByVisibleText("Cell Phones & Accessories");

        driver.findElement(By.cssSelector("#gh-btn")).click();

        driver.findElement(By.xpath("//span[text()='Apple iPhone X']")).click();
        Thread.sleep(3000);


    }

}
