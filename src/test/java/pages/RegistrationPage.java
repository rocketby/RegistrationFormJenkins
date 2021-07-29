package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

import components.Calendar;
import io.qameta.allure.Step;

import java.io.File;

public class RegistrationPage {
    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private Calendar calendar = new Calendar();

    @Step("Open main page")
    public void openPage(String URL) {
        open(URL);
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    @Step("Set first name: [{firstName}]")
    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    @Step("Set surname: [{lastName}]")
    public RegistrationPage setLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    @Step("Set email: [{email}]")
    public RegistrationPage setEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    @Step("Set gender: [{gender}]")
    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    @Step("Set phone: [{phone}]")
    public RegistrationPage setPhone(String phone) {
        $("#userNumber").val(phone);
        return this;
    }

    @Step("Set date of Birth: day= [{day}], month = [{month}], year = [{year}]")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    @Step("Set subject: [{subject}]")
    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Uploading file: [{file}]")
    public RegistrationPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    @Step("Set hobby: [{hobby}]")
    public RegistrationPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    @Step("Set address: [{address}]")
    public RegistrationPage setAddress(String address) {
        $("#currentAddress").val(address);
        return this;
    }

    @Step("Set state: [{state}]")
    public RegistrationPage setState(String state) {
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    @Step("Set city: [{city}]")
    public RegistrationPage setCity(String city) {
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    @Step("Submit registration!")
    public void submitRegistration() {
        $("button#submit").click();
    }

    @Step("Check, that page has title: [{RESULTS_TITLE}]")
    public void checkResultsTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
    }

    @Step("Check, that [{rowName}] has value: [{enteredValue}]")
    public void checkRegistrationResultData(String rowName, String enteredValue) {
        $x(format("//td[text()='%s']/following-sibling::td", rowName)).shouldHave(text(enteredValue));
    }

}