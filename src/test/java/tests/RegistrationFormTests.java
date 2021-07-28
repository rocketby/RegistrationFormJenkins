package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.*;

import java.io.File;

import pages.RegistrationPage;

public class RegistrationFormTests {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();
    DateAndTimeUtils dateAndTimeUtils = new DateAndTimeUtils();

    int phoneNumberLength = 10;
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = randomUtils.getRandomGender();
    String phone = faker.phoneNumber().subscriberNumber(phoneNumberLength);
    String year = "1980";
    String month = "10";
    String dayOfMonth = "21";
    String subjectFirst = "Maths";
    String subjectSecond = "Accounting";
    String fileLocation = "src/test/resources/";
    String fileName = "flower.jpg";
    String hobby = randomUtils.getRandomHobby();
    String address = faker.address().fullAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }


    @Test
    void positiveFillFormTest() {

        registrationPage.openPage();

        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDateOfBirth(dayOfMonth, month, year)
                .setSubject(subjectFirst)
                .setSubject(subjectSecond)
                .uploadFile(new File(fileLocation + fileName))
                .setHobby(hobby)
                .setAddress(address)
                .setState(state)
                .setCity(city);

        registrationPage.submitRegistration();

        registrationPage.checkResultsTitle();
        registrationPage.checkRegistrationResultData("Student Name", firstName + " " + lastName);
        registrationPage.checkRegistrationResultData("Student Email", email);
        registrationPage.checkRegistrationResultData("Gender", gender);
        registrationPage.checkRegistrationResultData("Mobile", phone);
        registrationPage.checkRegistrationResultData("Date of Birth",
                dayOfMonth + " " + dateAndTimeUtils.getMonthNameByNumber((Integer.valueOf(month))) + "," +year);
        registrationPage.checkRegistrationResultData("Subjects", subjectFirst + ", " + subjectSecond);
        registrationPage.checkRegistrationResultData("Hobbies", hobby);
        registrationPage.checkRegistrationResultData("Picture", fileName);
        registrationPage.checkRegistrationResultData("Address", address);
        registrationPage.checkRegistrationResultData("State and City", state + " " + city);

    }
}