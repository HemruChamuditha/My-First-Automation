import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitCommandsTest {

    public static void main(String[] args) throws InterruptedException {

        implicitWaitMethod();
    }

    private static void implicitWaitMethod() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(34));
        driver.get("https://demoqa.com/interaction");

        driver.findElement(By.xpath("//div[text()='Elements']")).click();
        driver.findElement(By.xpath("//li/span[text()='Text Box']")).click();

        Thread.sleep(1000);
    }
}
