package pl.susfenix.course.backend.simple_java.lesson2;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;

public class PeselInformation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your pesel.");
        String userInput = scanner.next();

        boolean isValid = isValid(userInput);
        if (!isValid) {
            System.out.println("Your pesel is incorrect");
            scanner.close();
            return;
        }
        System.out.println("Your pesel is " + isValid);
        System.out.println("You are a " + extractGender(userInput));
        System.out.println("You were born on " + extractBirthDayAsPreety(userInput)
                + " of " + extractBirthMonth(userInput)
                + " " + extractFullYear(userInput));
        //System.out.println(LocalDate.now());
        System.out.println("Your age yearly is: " + calculateAgeYearly(userInput));
        System.out.println("Your age exactly is: " + calculateAge(userInput));
        scanner.close();
        //00032187368 - 21.03.1900 ---> age: 125, exactly: 125
        //00032053573 - 20.03.1900 ---> age: 125, exactly: 124
        //00032285424 - 22.03.1900 ---> age: 125, exactly: 124
        //00022849298 - 28.02.1900 ---> age: 125, exactly: 125
        //00041021161 - 10.04.1900 ---> age: 125, exactly: 124
    }

    private static String extractGender(String pesel) {
        char genderDigitAsChar = pesel.charAt(9);
        int genderDigit = Character.getNumericValue(genderDigitAsChar);
        if (genderDigit % 2 == 1) {
            return "male";
        } else {
            return "female";
        }
    }

    private static int extractFullYear(String pesel) {
        int century = extractCentury(pesel);

        char birthYearAsChar1 = pesel.charAt(0);
        char birthYearAsChar2 = pesel.charAt(1);
        int birthYear1 = Character.getNumericValue((birthYearAsChar1));
        int birthYear2 = Character.getNumericValue((birthYearAsChar2));
        int birthYear = century + (birthYear1 * 10 + birthYear2);

        return birthYear;
    }

    private static int extractBirthDay(String pesel) {

        char birthDayAsChar1 = pesel.charAt(4);
        char birthDayAsChar2 = pesel.charAt(5);
        int birthDay1 = Character.getNumericValue((birthDayAsChar1));
        int birthDay2 = Character.getNumericValue((birthDayAsChar2));
        int birthDay = birthDay1 * 10 + birthDay2;
        return birthDay;

    }

    private static String extractBirthDayAsPreety(String pesel) {
        int birthDay = extractBirthDay(pesel);
        int birthDay2 = birthDay % 10;

        if (birthDay2 == 1) {
            return birthDay + "st";
        } else if (birthDay2 == 2) {
            return birthDay + "nd";
        } else if (birthDay2 == 3) {
            return birthDay + "rd";
        } else {
            return birthDay + "th";
        }
    }

    private static int extractCentury(String pesel) {
        int birthMonth = extractNumericPeselMonth(pesel);

        int century = -1;

        if (birthMonth > 80) {
            century = 1800;
        } else if (birthMonth > 60 && birthMonth < 80) {
            century = 2200;
        } else if (birthMonth > 40 && birthMonth < 60) {
            century = 2100;
        } else if (birthMonth > 20 && birthMonth < 40) {
            century = 2000;
        } else {
            century = 1900;
        }
        return century;
    }

    private static int extractNumericPeselMonth(String pesel) {
        char birthMonthAsChar1 = pesel.charAt(2);
        char birthMonthAsChar2 = pesel.charAt(3);
        int birthMonth1 = Character.getNumericValue((birthMonthAsChar1));
        int birthMonth2 = Character.getNumericValue((birthMonthAsChar2));
        int birthMonth = birthMonth1 * 10 + birthMonth2;
        return birthMonth;
    }

    private static String extractBirthMonth(String pesel) {

        int birthMonth = extractNumericPeselMonth(pesel) % 20;
        switch (birthMonth) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                throw new IllegalStateException("Should never happen");

        }

    }

    private static int calculateAgeYearly(String pesel) {
        int year = extractFullYear(pesel);
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - year;
    }

    private static int calculateAge(String pesel) {

        int month = extractNumericPeselMonth(pesel);
        int day = extractBirthDay(pesel);
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonth().getValue();
        int currentDay = currentDate.getDayOfMonth();

        int additionalMinus = 0;
        if (currentMonth - month < 0) {
            additionalMinus = 1;
        } else if (currentMonth == month && currentDay - day < 0) {
            additionalMinus = 1;
        }
        return calculateAgeYearly(pesel) - additionalMinus;
    }

    private static boolean isValid(String userInput) {

        if (userInput.length() != 11) {
            return false;
        }

        int[] weight = {1, 3, 7, 9};
        int sum = 0;

        for (int currentIndex = 0; currentIndex < userInput.length() - 1; currentIndex++) {
            char currentCharacter = userInput.charAt(currentIndex);
            if (!Character.isDigit(currentCharacter)) {
                return false;
            }
            int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
            sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length];
        }



        /*for (int currentIndex = 0; currentIndex < userInput.length() - 1;currentIndex++){
            char currentCharacter = userInput.charAt(currentIndex);
             int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
             sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length ];
        }*/
        sum = sum + Character.getNumericValue(userInput.charAt(userInput.length() - 1));

        return sum % 10 == 0;
    }

}



