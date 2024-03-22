package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    @DisplayName("Заполнение и проверка данных всех полей")
    void successfulRegistrationTest(){
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
    @DisplayName("Заполнение и проверка данных только обязательных полей")
    void fillRequiredFields(){
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
    @DisplayName("Валидация обязательных полей")
    void checkValidationEmptyFields(){
        registrationPage.openPage()
                .clickSubmit()
                .checkValidation();
    }
}