package lesson2;

/**
 * klasa słórząca do rozwiązywania problemów palindroma (wyraz czytany od tyłu i od przodu z tym samym znaczeniem)
 * np: kajak jest palindromem, ala jest palindromem, Kamil ślimak też
 * a bartek nie jest
 */
public class PalindromResolver {

    public static boolean isPalindrom(String word) {

        char[] wordInCharArray = word.toLowerCase()
                .trim()
                .toCharArray();

        //    int currentCharIndex = 0;


        //      while (currentCharIndex < Math.round( wordInCharArray.length/2)) {
        //  (int currentPow = 1; currentPow < powCounter; currentPow = currentPow + 1)
        for (int currentCharIndex = 0; currentCharIndex < Math.round(wordInCharArray.length / 2); currentCharIndex++) {
            char firstLetter = wordInCharArray[currentCharIndex];
            char lastLetter = wordInCharArray[wordInCharArray.length - currentCharIndex - 1];
            if (firstLetter != lastLetter) {
                return false;
            }

            //  currentCharIndex++;

        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("isPalindrom('Kajak')= " + isPalindrom("Kajak"));
        System.out.println("isPalindrom('ala')= " + isPalindrom("ala"));
        System.out.println("isPalindrom('oko')= " + isPalindrom("oko"));
        System.out.println("isPalindrom('Michal')= " + isPalindrom("Michal"));


    }


}

