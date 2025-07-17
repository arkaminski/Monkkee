package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Enter login and password  valid data", priority = 1)
    public void inputValidDateUserAndPassword () {
        loginPage.open()
                .enterLoginAndPassword(email, password)
                .userClickButton();
        Assert.assertTrue(mainPage.isPageOpen(),"Text does not match");
    }

    @Test(description = "Left the fields blank", priority = 2)
    public void noValidDateUserLeftFieldsBlank (){
        loginPage.open()
                .enterLoginAndPassword("","")
                .userClickButton();
        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");
    }

    @Test(description = "Left field name empty", priority = 2)
    public void noValidDateUserEnteredOnlyPassword () {
        loginPage.open()
                .enterLoginAndPassword("", "Resultreport5%")
                .userClickButton();
        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");
    }

    @Test(description = "Left field password empty", priority = 2)
    public void noValidDateUserEnteredOnlyName () {
        loginPage.open()
                .enterLoginAndPassword("artkami0612@gmail.com", "")
                .userClickButton();
        assertEquals(loginPage.errorMessageField(), "Mandatory field","Text does not match");
    }

    @Test(description = "Made a mistake in the name field", priority = 3)
    public void noValidDateUserEnteredNameWithError (){
        loginPage.open()
                .enterLoginAndPassword("artkami0612@gmail.com.",password)
                .userClickButton();
        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");
    }

    @Test(description = "Made a mistake in the password field", priority = 3)
    public void noValidDateUserEnteredPasswordWithError(){
        loginPage.open()
                .enterLoginAndPassword(email,"Resultreport5")
                .userClickButton();
        assertEquals(loginPage.errorMessageLogin(), "Login failed","Text does not match");
    }
}
