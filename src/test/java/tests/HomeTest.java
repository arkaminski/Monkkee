package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class HomeTest extends BaseTest {

    @Test(description = "Open website", priority = 1)
    public void opensWebsite() {
        homePage.open()
                .isPageOpen();
        assertTrue(homePage.isPageOpen());
    }

    @Test(description = "Click header menu about de", priority = 1)
    public void clickHeaderMenuAboutDe() {
        homePage.open()
                .choiceLanguageClick("Deutsch")
                .clickHeaderMenu("Über monkkee");
        assertEquals(homePage.getTextHomeRubricAbout(), "Online Tagebuch schreiben – privat und sicher",
                "Message does not match");
    }

    @Test(description = "Click header menu about en", priority = 3)
    public void clickHeaderMenuAboutEn() {
        homePage.open()
                .choiceLanguageClick("Français")
                .choiceLanguageClick("English")
                .clickHeaderMenu("About");
        assertEquals(homePage.getTextHomeRubricAbout(), "Keep a private and secure online diary",
                "Message does not match");
    }

    @Test(description = "Click header menu about fr", priority = 3)
    public void clickHeaderMenuAboutFr() {
        homePage.open()
                .choiceLanguageClick("Français")
                .clickHeaderMenu("A propos");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenir un journal intime en ligne – privé et sécurisé",
                "Message does not match");
    }

    @Test(description = "Click header menu about pt", priority = 3)
    public void clickHeaderMenuAboutPt() {
        homePage.open()
                .choiceLanguageClick("Portuguese")
                .clickHeaderMenu("Sobre");

        assertEquals(homePage.getTextHomeRubricAbout(), "Tenha um diário online privado e seguro",
                "Message does not match");
    }

    @Test(description = "Click header menu features de", priority = 3)
    public void clickHeaderMenuFeaturesDe() {
        homePage.open()
                .choiceLanguageClick("Deutsch")
                .clickHeaderMenu("Funktionen");

        assertEquals(homePage.getTextHomeRubricFeatures(), "Ohne Schnickschnack - die Funktionen von monkkee",
                "Message does not match");
    }

    @Test(description = "Click header menu features en", priority = 3)
    public void clickHeaderMenuFeaturesEn() {
        homePage.open()
                .choiceLanguageClick("Français")
                .choiceLanguageClick("English")
                .clickHeaderMenu("Features");

        assertEquals(homePage.getTextHomeRubricFeatures(), "monkkee’s features - no bells and whistles," +
                " plain functionality","Message does not match");

    }

    @Test(description = "Click header menu fea" + "" + "tures fr", priority = 2)
    public void clickHeaderMenuFeaturesFr() {
        homePage.open()
                .choiceLanguageClick("Français")
                .clickHeaderMenu("Fonctionnalités");

        assertEquals(homePage.getTextHomeRubricFeatures(), "monkkee - tout simplement fonctionnel",
                "Message does not match");
    }

    @Test(description = "Click header menu features pt", priority = 2)
    public void clickHeaderMenuFeaturesPt() {
        homePage.open()
                .choiceLanguageClick("Portuguese")
                .clickHeaderMenu("Recursos");
        assertEquals(homePage.getTextHomeRubricFeatures(),
                "Características do monkkee - Sem recursos adicionais," +
                        " funcionalidade simples", "Message does not match");
    }

    @Test(description = "Click header menu security de", priority = 2)
    public void clickHeaderMenuSecurityDe() {
        homePage.open()
                .choiceLanguageClick("Deutsch")
                .clickHeaderMenu("Sicherheit");
        assertEquals(homePage.getTextHomeRubricSecurity(),
                "Sicherheit durch Ende-zu-Ende-Verschlüsselung","Message does not match");
    }

    @Test(description = "Click header menu security en", priority = 3)
    public void clickHeaderMenuSecurityEn() {
        homePage.open().
                choiceLanguageClick("Français")
                .choiceLanguageClick("English")
                .clickHeaderMenu("Security");
        assertEquals(homePage.getTextHomeRubricSecurity(), "Secure end-to-end encryption",
                "Message does not match");
    }

    @Test(description = "Click header menu security fr", priority = 3)
    public void clickHeaderMenuSecurityFr() {
        homePage.open()
                .choiceLanguageClick("Français")
                .clickHeaderMenu("Sécurité");
        assertEquals(homePage.getTextHomeRubricSecurity(),
                "Chiffrement de bout en bout pour une sécurité maximale","Message does not match");
    }

    @Test(description = "Click header menu security pt", priority = 3)
    public void clickHeaderMenuSecurityPt() {
        homePage.open()
                .choiceLanguageClick("Portuguese")
                .clickHeaderMenu("Segurança");
        assertEquals(homePage.getTextHomeRubricSecurity(),
                "Criptografia segura de ponta a ponta", "Message does not match");
    }

    @Test(description = "Click header menu donate de", priority = 2)
    public void clickHeaderMenuDonateDe() {
        homePage.open()
                .choiceLanguageClick("Deutsch")
                .clickHeaderMenu("Sicherheit");
        assertEquals(homePage.getTextHomeRubricDonate(),
                "Was kostet monkkee?","Message does not match");
    }
}
