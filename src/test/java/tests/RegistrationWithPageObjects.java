package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class RegistrationWithPageObjects extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulRegistrationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("Ivanov@mail.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("15", "February", "2000")
                .setSubjects("Accounting")
                .setHobbies("Sports")
                .uploadPicture("jenkins.png")
                .setAddress("Улица Пушкина, д.7, кв 83")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkResult("Student Name", "Иван Иванов")
                .checkResult("Student Email", "Ivanov@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "15 February,2000")
                .checkResult("Subjects", "Accounting")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "jenkins.png")
                .checkResult("Address", "Улица Пушкина, д.7, кв 83")
                .checkResult("State and City", "NCR Delhi");
    }


    @Test
    void fillRequiredFields(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setGender("Male")
                .setUserNumber("1234567890")
                .clickSubmit()
                .checkResult("Student Name", "Иван Иванов")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890");
    }


    @Test
    void checkValidationEmptyFields(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openPage()
                .clickSubmit()
                .checkValidation();
    }
}