import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AlertCommandsTest {
    public static void main(String[] args) throws InterruptedException {

//        alertWithOk();
        alertWithOkAndCancel();

    }

    private static void alertWithOkAndCancel() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("btn-primary")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement element = driver.findElement(By.id("demo"));
        System.out.println(element.getText());
        Thread.sleep(2000);


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
