package lesson1;

public class StringFunner {

    public static void main(String[] args) {


        numbers();
        isPalindrom("kajak");

    }

    /**
     * Palindrom to wyraz czytany od przodu i tyłu tak samo
     * isPalindrom("kajak"); = true
     * isPalindrom("Tymek"); = false
     */
    private static boolean isPalindrom(String word1) {
        return false;
    }

    public static void numbers() {
        int fullNumber = 5;
        fullNumber = 40;

        double decimalNumber = 40.5;
        float legacyDecimalNumber = 40.5f;

        boolean trueValue = true;

        char charValue = 'k';

        String stringValue = "Hello World!";

        String[] stringValues = new String[8];
        stringValues[0] = "My First String";
        stringValues[1] = "My 2nd String";
        stringValues[7] = "My last String";

        System.out.println("fullNumber = " + fullNumber);
        System.out.println("decimalNumber = " + decimalNumber);
        System.out.println("legacyDecimalNumber = " + legacyDecimalNumber);
        System.out.println("charValue = " + charValue);
        System.out.println("stringValue = " + stringValue);
        System.out.println("stringValues[0] = " + stringValues[0]);
        System.out.println("stringValues[1] = " + stringValues[1]);

        for (String currentValue : stringValues) {
            System.out.println("Current Value = " + currentValue);
        }
    }

}
