package pl.susfenix.course.backend.simple_java.lesson2.object.pesel;

public class PeselValidator {

    public static boolean isValid(String pesel) {

        if (pesel.length() != 11) {
            return false;
        }

        int[] weight = {1, 3, 7, 9};
        int sum = 0;

        for (int currentIndex = 0; currentIndex < pesel.length() - 1; currentIndex++) {
            char currentCharacter = pesel.charAt(currentIndex);
            if (!Character.isDigit(currentCharacter)) {
                return false;
            }
            int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
            sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length];
        }



        /*for (int currentIndex = 0; currentIndex < pesel.length() - 1;currentIndex++){
            char currentCharacter = pesel.charAt(currentIndex);
             int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
             sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length ];
        }*/
        sum = sum + Character.getNumericValue(pesel.charAt(pesel.length() - 1));

        return sum % 10 == 0;
    }

}


