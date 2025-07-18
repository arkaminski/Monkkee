package tests;

import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TextEditorTest extends BaseTest {

    @Test(description = "Loading File ", priority = 1)
    @Owner("akaminski")
    public void loadingFileFormat() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton()
                .selectSettingLanguage();
        settingsPage.selectLanguage()
                .clickButtonOkLanguage();
        settingsPage.clickButtonSettingsHome();
        mainPage.clickCreateButton();
        textEditorPage.buttonBlockEmage()
                .selectFileLoading()
                .clickButtonSave();
        assertTrue(homePage.isPageOpen());
        mainPage.clickButtonHome();
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }
}
