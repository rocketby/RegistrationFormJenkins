package utils;

public class DateAndTimeUtils {

    public static String getMonthNameByNumber(int month){
        String[] monthNames = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}