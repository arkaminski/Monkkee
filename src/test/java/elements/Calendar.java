package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

@Log4j2

public class Calendar {
    WebDriver driver;

    public Calendar(WebDriver driver) {
        this.driver = driver;
    }

    public static By CALENDAR_LOCATOR = By.id("datepicker");
    public static By GET_MESSAGE_CALENDAR = By.xpath(
            "//div[@class = 'entries__calendar-date d-none d-xl-block']");
    public static String monthYearLocator = "//div[contains(@class ,'datepicker dropdown-menu')]//th[text() = '%s']";
    public static String dayLocator = "//div[contains(@class, 'datepicker')]//td[text() = '%s']";

    public Calendar selectDate(String monthYear, String day) throws InterruptedException {
        driver.findElement(CALENDAR_LOCATOR).click();
        log.info("Сlick on the calendar field ");
        driver.findElement(By.xpath(String.format(monthYearLocator, monthYear))).getText();
        log.info("Enter date and year " + monthYear);
        driver.findElement(By.xpath(String.format(dayLocator, day))).click();
        log.info("Select and click on the day " + day);
        return this;
    }

    public String getMessageEntries () {
        String dataMessage = driver.findElement(GET_MESSAGE_CALENDAR).getText();
        log.info("Receive a message about a found record");
        return dataMessage;
    }
}
