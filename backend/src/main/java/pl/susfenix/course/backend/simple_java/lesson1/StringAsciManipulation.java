package pl.susfenix.course.backend.simple_java.lesson1;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Pobieraj od użytkownika napis, dopóki nie będzie składał się z samych
 * dużych liter. Przeprowadź analizę pobranego napisu:
 * <p>
 * a) Zlicz, ile w napisie znajduje się znaków, których kod ASCII
 * posiada nieparzystą cyfrę jedności
 * b) Oblicz sumę kodów ASCII znaków znajdujących się na parzystych
 * indeksach w napisie. Następnie znajdź pierwszą liczbę z
 * przedziału <65, 90>, która jest dzielnikiem wyznaczonej wcześniej
 * * sumy. Będzie to kod ASCII jednej z dużych liter alfabetu
 * c) Zlicz, ile w napisie występuje liter większych od wyznaczonej litery.
 * <p>
 * https://www.alpharithms.com/wp-content/uploads/340/ascii-table-alpharithms-scaled.jpg
 */


public class StringAsciManipulation {

    public static void start() {

        String retrivedWord = retrieveUpperCaseWordFromUser();

        int[] convertedWord = convertToAscii(retrivedWord);

        System.out.println("Converted word:" + Arrays.toString(convertedWord));

        System.out.printf("There are %d odd numbers in %s word \n ", countOddDigits(convertedWord), retrivedWord);

        int sumedOfAllEvenDigitsIndexes = sumOfAllEvenDigitsIndexes(convertedWord);

        System.out.println("sumOfAllEvenDigitsIndexes: " + sumedOfAllEvenDigitsIndexes);

        System.out.println("findNumberWhichIsSumDivider: " + findNumberWhichIsSumDivider(convertedWord, sumedOfAllEvenDigitsIndexes));

        System.out.println("Counter: " + countLettersHigherThen(convertedWord, 65));
    }

    private static String retrieveUpperCaseWordFromUser() {
        final Scanner scanner = new Scanner(System.in);
        String retrivedWordFromUser = scanner.next();

        while (!retrivedWordFromUser.toUpperCase().equals(retrivedWordFromUser)) {
            retrivedWordFromUser = scanner.next();
        }
        scanner.close();

        return retrivedWordFromUser;
    }

    // TYMEK ------> [84, 89, 77, 69, 75], sum = 236
    private static int[] convertToAscii(String retrivedWord) {
        byte[] asciiCodeInBytes = retrivedWord.getBytes(StandardCharsets.US_ASCII);
        int[] asciiCodeInNumber = new int[asciiCodeInBytes.length];
        for (int currentIndex = 0; currentIndex < asciiCodeInBytes.length; currentIndex++) {
            asciiCodeInNumber[currentIndex] = asciiCodeInBytes[currentIndex];

        }
        return asciiCodeInNumber;
    }

    private static int countOddDigits(int[] convertedWord) {
        int counter = 0;
        for (int currentIndex = 0; currentIndex < convertedWord.length; currentIndex++) {
            int currentDigit = convertedWord[currentIndex];
            if (currentDigit % 2 == 1) {
                counter++;
            }
        }
        return counter;
    }

    private static int sumOfAllEvenDigitsIndexes(int[] usersWord) {
        int summedIndexDigits = 0;
        for (int currentIndex = 0; currentIndex < usersWord.length; currentIndex += 2) {
            summedIndexDigits += usersWord[currentIndex];
        }
        return summedIndexDigits;
    }

    private static int findNumberWhichIsSumDivider(int[] usersWord, int sumedOfAllEvenDigitsIndexes) {

        int minBound = 65;
        int maxBound = 90;

        for (int currentIndex = 0; currentIndex < usersWord.length; currentIndex++) {
            int currentAsciiWord = usersWord[currentIndex];
            if (currentAsciiWord % sumedOfAllEvenDigitsIndexes == 0) {
                return currentAsciiWord;
            }

        }

        return -1;
        // throw new IllegalArgumentException("Not found number witch is sum divider ");
    }

    //Zlicz, ile w napisie występuje liter większych od wyznaczonej litery.

    // TYMEK ------> [84, 89, 77, 69, 75], count = 5

    private static int countLettersHigherThen(int[] usersWord, int minNumber) {

        int counter = 0;

        for (int currentNumberCheck : usersWord) {
            if (currentNumberCheck > minNumber) {
                counter = counter + 1;
            }
        }


        return counter;
    }


    public static void main(String[] args) {

        start();


    }
}




