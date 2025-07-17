package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class MainTest extends BaseTest {
    String enteredText = "How to use AI in chrome 64 using selenium Java";
    String homeTextNotebook = "How to use AI in chrome 64 using selenium Java";
    String monthYear = "July 2025";
    String day = "16";
    String messageCalendar = "16 Jul. 2025";
    String textTags = "How to use AI in chrome 64 using selenium Java";


    @Test(description = "Create entry", priority = 1)
    public void createEntry() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .textMessageRecords(homeTextNotebook);
        assertEquals(enteredText, homeTextNotebook, "Текс не совподает");
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }

    @Test (description = "Language selection settings", priority = 1)
    public void selectAndDeleteCheckBox() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        String alertText = contextMenuPage.getText();
        assertEquals(alertText, "Do you really want to delete the selected entries?", "Текст сообщения не верный");
        contextMenuPage.alertAccept();
    }

    @Test(description = "Search for text by text", priority = 1)
    public void searchTextByText() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .searchInput(enteredText)
                .messageSearch();
        assertEquals(mainPage.messageSearch(), enteredText, "Text does not match");
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }

    @Test(description = "Search text for calendar", priority = 1)
    public void searchTextByDate() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton(); mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.clickButtonHome()
                .selectDate(monthYear,day);
        assertEquals(mainPage.getMessageCalendar(),messageCalendar,"Text does not match");
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }

    @Test(description = "Adding a tag to a post", priority = 1)
    public void createTagInPost() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText);
        mainPage.createTagPost(enteredText);
        textEditorPage.clickButtonSave();
        mainPage.clickButtonHome();
        assertEquals(mainPage.getMessageTags(),enteredText,"Text does not match");
        mainPage.selectCheckBox();
        contextMenuPage.clickButtonDelete()
                .getText();
        contextMenuPage.alertAccept();
    }

    @Test(description = "Delete tag by name", priority = 1)
    public void deleteTag() throws InterruptedException {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        mainPage.clickCreateButton();
        textEditorPage.enterText(enteredText)
                .clickButtonSave();
        mainPage.createTagPost(enteredText);
        mainPage.clickButtonHome()
                .clickButtonTextTag()
                .selectingTagName(textTags);
        contextMenuPage.clickButtonTeg();
        contextMenuPage.getText();
        String alertText = contextMenuPage.getText();
        assertEquals(alertText, "Do you really want to delete the tag? " +
                "All entries related to the tag remain unchanged.", "Текст сообщения не верный");
        contextMenuPage.alertAccept();
    }
}
