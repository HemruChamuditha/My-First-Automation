import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameCommandsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");
        WebElement element = driver.findElement(By.id("singleframe"));

        WebDriver frame = driver.switchTo().frame(element);
        WebElement element1 = driver.findElement(By.xpath("//input[@type='text']"));
        element1.sendKeys("hyyyyy");
        Thread.sleep(2000);

    }
}
