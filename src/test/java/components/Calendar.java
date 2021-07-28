package components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        String dayLocator = format(".react-datepicker__day--0%s" +
                ":not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();
    }
}