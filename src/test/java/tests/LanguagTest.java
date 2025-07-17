package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Log4j2
public class LanguagTest extends BaseTest {
    String textFr = "Langue temporairement changée. Afin de changer de façon permanente la langue " +
            "de votre compte, veuillez accéder au point de menu \"Paramètres\" après le login.";
    String textDe = "Sprache temporär geändert. Um deine Profil-Sprache dauerhaft zu ändern, besuche " +
            "den Menüpunkt \"Einstellungen\" nach dem Login.";
    String textPt = "Idioma alterado temporariamente. Para modificar a linguagem de seu perfil permanentemente, " +
            "vá para o item do menu \"Configurações\" após estar logado.";
    String textEn = "Language changed temporarily. To change your profile language permanently, " +
            "go to the menu item \"Settings\" after login.";

    @Test(description = "Page language de selection", priority = 1)
    public void changeLanguageDe () throws InterruptedException {
        loginPage.open();
        languagePage.languageSelection("Deutsch");
        assertEquals(languagePage.languageMessage(),textDe,"Text does not match");
        languagePage.languageSelection("English");
    }

    @Test(description = "Page language fr selection", priority = 3)
    public void changeLanguageFr () throws InterruptedException {
        loginPage.open();
        languagePage.languageSelection("Français");
        assertEquals(languagePage.languageMessage(),textFr,"Text does not match");
        languagePage.languageSelection("English");
    }

    @Test(description = "Page language pt selection", priority = 2)
    public void changeLanguagePT () throws InterruptedException {
        loginPage.open();
        languagePage.languageSelection("Portuguese");
        assertEquals(languagePage.languageMessage(),textPt,"Text does not match");
        languagePage.languageSelection("English");
    }

    @Test(description = "Page language en selection", priority = 3)
    public void changeLanguageEn () throws InterruptedException {
        loginPage.open();
        languagePage.languageSelection("Français")
                .languageSelection("English");
        assertEquals(languagePage.languageMessage(), textEn, "Text does not match");
        languagePage.languageSelection("Portuguese");
    }
}
