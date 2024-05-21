package com.qacart.todo.pages;

import com.qacart.todo.base.BaseTest;

import java.util.Random;

public class Regex extends BaseTest {
    public static String jordanIdValue;
    public static String jordanMobileValue;
    public static String arabicName;

    public String regexForId() {
        String jordanianIDRegex = "^([9][0-9]{2}[12][0][0-9]\\d{4}$)|([2][0]{2}[0-9]{7})$/";// Your desired regex pattern

        String randomGeneratedNumber = generateRandomNumber(jordanianIDRegex);
        System.out.println("Random Generated Number: " + randomGeneratedNumber);
        jordanIdValue = randomGeneratedNumber;
        return jordanIdValue;
    }

    public String regexForMobile() {
        String jordanianMobileRegex = "^(07[789]\\d{7})$";// Your desired regex pattern

        String randomGeneratedNumber = generateRandomNumber(jordanianMobileRegex);
        System.out.println("Random Generated Number: " + randomGeneratedNumber);
        jordanMobileValue = randomGeneratedNumber;
        return jordanMobileValue;
    }

    private static String generateRandomNumber(String regexPattern) {
        Random random = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();

        // Keep generating random digits until the pattern is satisfied
        do {
            randomStringBuilder.setLength(0); // Clear the StringBuilder
            for (int i = 0; i < 10; i++) {
                randomStringBuilder.append(random.nextInt(10));
            }
        } while (!randomStringBuilder.toString().matches(regexPattern));

        return randomStringBuilder.toString();
    }


    public static String generateRandomArabicName() {
        StringBuilder name = new StringBuilder();
        Random random = new Random();

        // Arabic characters range in Unicode
        int min = 0x0621; // Start of Arabic Unicode range
        int max = 0x064A; // End of Arabic Unicode range

        // Generate a random length for the name (between 3 and 10 characters)
        int length = random.nextInt(8) + 3;

        for (int i = 0; i < length; i++) {
            // Generate a random Arabic character
            int codePoint = random.nextInt(max - min + 1) + min;
            name.append(Character.toChars(codePoint));
        }
        arabicName = name.toString();
        return arabicName;
    }
}