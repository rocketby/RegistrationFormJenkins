package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

import components.Calendar;

import java.io.File;

public class RegistrationPage {
    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private Calendar calendar = new Calendar();

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    public RegistrationPage setLastName(String firstName) {
        $("#lastName").val(firstName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        $("#userNumber").val(phone);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }


    public RegistrationPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage setAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String state) {
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public void submitRegistration() {
        $("button#submit").click();
    }

    public void checkResultsTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
    }

    public void checkRegistrationResultData(String rowName, String enteredValue) {
        $x(format("//td[text()='%s']/following-sibling::td", rowName)).shouldHave(text(enteredValue));
    }

}