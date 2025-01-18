import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementInteractionCommandsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");
//        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']/input[@class='gh-search-input gh-tb ui-autocomplete-input']")).sendKeys("apple watch");
        driver.findElement(By.cssSelector("div > button > span[class=\"gh-search-button__label\"]")).click();
//        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']/input[@class='gh-search-input gh-tb ui-autocomplete-input']")).clear();
        driver.findElement(By.cssSelector("input[aria-label=\"Apple Watch Series SE\"]")).click();
        driver.findElement(By.cssSelector("input[aria-label=\"Apple Watch Series 7\"]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='s-item__title']/span[@role='heading']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
}
