package utils;

import java.util.Random;

public class RandomUtils {

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        int numberOfRandomElement = getRandomNumber(0, gender.length);
        System.out.println(gender.length);
        return (gender[numberOfRandomElement]);
    }

    public String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        int numberOfRandomElement = getRandomNumber(0, hobby.length);
        return (hobby[numberOfRandomElement]);
    }
}