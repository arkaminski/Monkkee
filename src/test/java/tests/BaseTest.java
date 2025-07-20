package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.*;
import utils.DriverFactory;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

import static utils.AllureUtils.takeScreenshot;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    String email, password;
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;
    TextEditorPage textEditorPage;
    ContextMenuPage contextMenuPage;
    SettingsPage settingsPage;

    LanguagePage languagePage;

    @Parameters({"browser"})
    @BeforeMethod

    @Step("Setting up and opening the browser")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        email = System.getenv().getOrDefault("MONKKEE_EMAIL", PropertyReader.getProperty("monkkee.email"));
        password = System.getenv().getOrDefault("MONKKEE_PASSWORD",
                PropertyReader.getProperty("monkkee.password"));
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
        this.textEditorPage = new TextEditorPage(driver);
        this.contextMenuPage = new ContextMenuPage(driver);
        this.settingsPage = new SettingsPage(driver);
        this.languagePage = new LanguagePage(driver);
    }

    @Step("Exit the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        driver.quit();
    }
}
