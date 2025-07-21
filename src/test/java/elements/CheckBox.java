package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CheckBox {
    WebDriver driver;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public static By CHECK_BOX_LOCATOR = By.xpath(
            "//input[@type = 'checkbox']");

    public CheckBox selectCheckBox() {
        List<WebElement> entry = driver.findElements(CHECK_BOX_LOCATOR);
        entry.get(1).click();
        log.info("List entre checkBox");
        return this;
    }
}
