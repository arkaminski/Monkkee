package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LanguagePage extends BasePage{
    public static final By dropdownToggle = By.xpath("//a[contains(@class, 'dropdown-toggle')]");

    @Step("Choose language page")
    public LanguagePage languageSelection(String language) throws InterruptedException {
        Thread.sleep(1200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownToggle)).click();
        driver.findElement(By.xpath(String.format(languageLocator, language))).click();
        log.info("Choose language page " + language);
        return this;
    }

    @Step("Language change message")
    public String languageMessage(){
        return driver.findElement(LANGUAGE_TEXT).getText();
    }

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(PAGE_LOCATOR);
    }
}
