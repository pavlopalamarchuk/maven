import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class pavlotest {

    public static void main(String args[]) {
        createInstance();
    }

    public static WebDriver createInstance() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pavlo\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("http://bestdeals.today");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement searchField = driver.findElement(By.cssSelector("#main-div > section.home-showcase > div > div > div > input"));
        searchField.sendKeys("iphone 8");
        WebElement searchButton = driver.findElement(By.cssSelector("#main-div > section.home-showcase > div > div > div > button"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dealsNumber = driver.findElement(By.cssSelector("#main-div > div.main-container__bottom > div.deals-container > div.deals-container__content > main > header > div.deals-titles__left > div > div.deals-category__deals-found > span"));
        String s = dealsNumber.getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bestdeals.today/iphone-8?utf8=%E2%9C%93&filter_inuse=true&new_filter=true&search=iphone+8&from_price=3.00&to_price=1369.00&fixed_price=true");
        WebElement dealsNumber2 = driver.findElement(By.cssSelector("#main-div > div.main-container__bottom > div.deals-container > div.deals-container__content > main > header > div.deals-titles__left > div > div.deals-category__deals-found > span"));
        String x = dealsNumber2.getText();
        int result1 = Integer.parseInt(s);
        int result2 = Integer.parseInt(x);
        if (result1>result2){
            System.out.print("Filter is work correct");}
        else System.out.print("Filter is not work correct");
        return driver;
    }
}




