import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateCommandsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.get("https://www.ebay.com/");
        System.out.println("1 : " + driver.getTitle());

        driver.findElement(By.xpath("//li/a[contains(text(),'Home & Garden')]")).click();
        System.out.println("2 : " + driver.getTitle());
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(1000);
        System.out.println("3 : " + driver.getTitle());

        driver.navigate().refresh();
        Thread.sleep(1000);
        System.out.println("4 : " + driver.getTitle());

        driver.navigate().forward();
        Thread.sleep(1000);
        System.out.println("5 : " + driver.getTitle());

        driver.quit();
    }
}
