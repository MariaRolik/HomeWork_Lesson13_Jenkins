package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ModalWindowComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement

            userForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ModalWindowComponent modalWindowComponent = new ModalWindowComponent();


    @Step("Открыть страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    @Step("Ввести имя: {0}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }


    @Step("Ввести фамилию: {0}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email: {0}")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбрать гендер: {0}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Указать номер телефона: {0}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Выбрать дату рождения: {0} {1} {2}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать Предмет: {0}")
    public RegistrationPage setSubjects (String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать хобби: {0}")
    public RegistrationPage setHobbies (String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }


    @Step("Загрузить изображение: {0}")
    public RegistrationPage uploadPicture(String img) {
        pictureInput.uploadFromClasspath(img);
        return this;
    }

    @Step("Ввести адрес: {0}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат: {0}")
    public RegistrationPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }
    @Step("Выбрать город: {0}")
    public RegistrationPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }


    @Step("Нажать кнопку Submit")
    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }



    @Step("Проверить введнные данные: поле {0} - значение {1}")
    public RegistrationPage checkResult(String fieldName, String value) {
        modalWindowComponent.checkSubmitForm(fieldName, value);
        return this;
    }

    @Step("Проверить валидацию незаполненных полей")
    public void checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Male")).shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Female")).shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$(byText("Other")).shouldHave(cssValue(valueName,colorRed));
        userNumberInput.shouldHave(cssValue(valueName,colorRed));
    }


}