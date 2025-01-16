import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class EbayDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        //Accessing the particular website through the get method
        driver.get("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(3000);




    }
}