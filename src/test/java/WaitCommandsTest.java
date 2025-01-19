import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitCommandsTest {

    public static void main(String[] args) throws InterruptedException {

//        implicitWaitMethod();
//        explicitWaitMethod();
        fluentWaitMethod();
    }

    private static void fluentWaitMethod() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement visibleAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        visibleAfter.click();
        System.out.println(visibleAfter.getText());
    }

    private static void explicitWaitMethod() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement enableAfter = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        System.out.println(enableAfter.getText());
        enableAfter.click();

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
