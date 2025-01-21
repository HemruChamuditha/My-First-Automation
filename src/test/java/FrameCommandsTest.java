import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FrameCommandsTest {

    public static void main(String[] args) throws InterruptedException {

//      singleFrame();
        nestedFrame();
    }

    private static void nestedFrame() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

        WebElement element = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        WebDriver frame = driver.switchTo().frame(element);

//        System.out.println(driver.findElement(By.xpath("//h5[text()='Nested iFrames']")).getText());
        WebElement element1 = driver.findElement(By.cssSelector("h5 + iframe"));
        WebDriver frame1 = driver.switchTo().frame(element1);

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("hello");
        Thread.sleep(2000);

//        List<WebElement> elements = driver.findElements(By.xpath("//h5[text()='iFrame Demo']"));
//        System.out.println(elements.get(0).getText());


    }

    private static void singleFrame() throws InterruptedException {
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
