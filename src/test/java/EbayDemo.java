import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class EbayDemo {

    public static void main(String[] args) throws InterruptedException {

        //newTabbedWindowTest();
        newSeparateWindowTest();
    }

    public static void newTabbedWindowTest() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //Accessing the particular website through the get method
        driver.get("https://demo.automationtesting.in/Windows.html");

        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);
        System.out.println(driver.getTitle());

        //Clicking the "Open New Tabbed windows" Link
        driver.findElement(By.xpath("//a[contains(text(), 'Open New Tabbed Windows')]")).click();

        //clicking the click Button
        driver.findElement(By.xpath("//a/button[contains(text(),'click')]")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String window : windowHandles){
            if (!(window.contains(parentWindow))){
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
    }

    public static void newSeparateWindowTest() throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Windows.html");

        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//li/a[text()='Open New Seperate Windows']")).click();

        driver.findElement(By.xpath("//div[@id='Seperate']/button[contains(text(),'click')]")).click();
        Thread.sleep(2000);

        System.out.println(driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles){
            if (window.contains(parentWindow)){

            }else {
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

    }
}