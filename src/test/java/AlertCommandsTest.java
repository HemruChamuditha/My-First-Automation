import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertCommandsTest {
    public static void main(String[] args) throws InterruptedException {

        alertWithOk();
    }

    private static void alertWithOk() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("[id='alertButton']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();


    }
}
