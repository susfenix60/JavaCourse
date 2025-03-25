package pl.susfenix.course.backend.simple_java.lesson2.object.pesel;

import pl.susfenix.course.backend.simple_java.lesson2.object.pesel.model.PeselData;

import java.time.LocalDate;

public class PeselExtractor {
    public static PeselData fromPesel(String pesel){
        int birthDay = extractBirthDay(pesel);
        int century = extractCentury(pesel);
        int fullYear = extractFullYear(pesel);
        String gender = extractGender(pesel);
        int numericPeselMonth = extractNumericPeselMonth(pesel);
        return new PeselData(LocalDate.of(fullYear, numericPeselMonth, birthDay), fullYear, century, numericPeselMonth, birthDay, gender);
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
}
