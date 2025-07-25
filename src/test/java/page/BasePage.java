package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;
import java.time.Duration;

public abstract class BasePage {
    WebDriverWait wait;
    WebDriver driver;
    String BASE_URL = "https://monkkee.com";
    String languageLocator = "//a[@class= 'dropdown-item' and text()= '%s']";
    public static final By LANGUAGE_TEXT = By.xpath("//div[@class = 'alert alert-success']");
    public static final By PAGE_LOCATOR = By.xpath("//a[text() = 'Homepage']");

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.getenv().getOrDefault("MONKKEE_URL", PropertyReader.getProperty("monkkee.url"));
    }

    public abstract boolean isPageOpen();
    public boolean isExist(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
