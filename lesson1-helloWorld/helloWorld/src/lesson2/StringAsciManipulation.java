package lesson2;

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
 * sumy. Będzie to kod ASCII jednej z dużych liter alfabetu Zlicz,
 * ile w napisie występuje liter większych od wyznaczonej litery.
 * <p>
 * https://www.alpharithms.com/wp-content/uploads/340/ascii-table-alpharithms-scaled.jpg
 */


public class StringAsciManipulation {

    public static void start() {

        String retrivedWord = retrieveUpperCaseWordFromUser();

        int[] convertedWord = convertToAscii(retrivedWord);

        System.out.println("Converted word:" + Arrays.toString(convertedWord));
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

    // TYMEK ------> [84, 89, 77, 69, 75]
    private static int[] convertToAscii(String retrivedWord) {
        byte[] asciiCodeInBytes = retrivedWord.getBytes(StandardCharsets.US_ASCII);
        int[] asciiCodeInNumber = new int[asciiCodeInBytes.length];
        for (int currentIndex = 0; currentIndex < asciiCodeInBytes.length; currentIndex++) {
            asciiCodeInNumber[currentIndex] = asciiCodeInBytes[currentIndex];

        }
        return asciiCodeInNumber;
    }

    public static void main(String[] args) {

        start();

    }
}




