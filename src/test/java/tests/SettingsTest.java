package tests;

import io.qameta.allure.Owner;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SettingsTest extends BaseTest {
    String textLanguage = "Seu idioma foi alterado com sucesso";
    String textTimeAndAlies = "Your settings have been saved successfully";

    @Test(description = "Language selection settings", priority = 1)
    public void languageSelectionSettings() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton()
                .selectSettingLanguage();
        settingsPage.selectLanguage()
                .clickButtonOkLanguage();

        assertEquals(settingsPage.textMessageLanguage("Seu idioma foi alterado com sucesso"),
                textLanguage,"Text does not match");
    }

    @Test(description = "logout", priority = 2)
    public void logout () {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.logout();
        assertTrue(homePage.isPageOpen());
    }

    @Test(description = "Adding a login alias instead of email", priority = 3)
    public void addingAlies() throws InterruptedException, IOException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton()
                .selectSettingAlies()
                .nicknameClickCheckBox();
        settingsPage.selectNickName("Hotel2");
        settingsPage.clickButtonOkTime();
        assertEquals(settingsPage.getMessageTextAliasAndTime("Your settings have been saved successfully"),
                textTimeAndAlies,"Text does not match");
        settingsPage.deleteNickName();
        settingsPage.nicknameClickCheckBox();
        settingsPage.clickButtonOkTime();
    }

    @Test(description = "Change page time", priority = 2)
    @Owner("akaminski")
    public void changePageTime() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        settingsPage.clickSettingButton()
                .selectSettingTimeout();
        settingsPage.clickButtonTime()
                .listTimeLimit()
                .clickButtonOkTime();
        assertEquals(settingsPage.getMessageTextAliasAndTime("Your settings have been saved successfully"),
                textTimeAndAlies,"Text does not match");
    }
}
