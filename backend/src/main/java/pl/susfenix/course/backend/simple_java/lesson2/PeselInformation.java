package pl.susfenix.course.backend.simple_java.lesson2;

import java.time.LocalDate;
import java.util.Locale;

public class PeselInformation {

    public static void main(String[] args) {

        String userInput = "92080811851"; //TODO implement method scanner

        boolean isValid = isValid(userInput);
        System.out.println(isValid);

        //System.out.println(LocalDate.now());
    }

    private static boolean isValid(String userInput) {

        if (userInput.length() != 11){
            return false;
        }

        int[] weight = {1,3,7,9};
        int sum = 0;

        for (int currentIndex = 0; currentIndex < userInput.length() - 1;currentIndex++){
            char currentCharacter = userInput.charAt(currentIndex);
            if (!Character.isDigit(currentCharacter)) {
                return false;
            }
            int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
            sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length ];
        }



        /*for (int currentIndex = 0; currentIndex < userInput.length() - 1;currentIndex++){
            char currentCharacter = userInput.charAt(currentIndex);
             int currentCharacterAsNumber = Character.getNumericValue(currentCharacter);
             sum = sum + currentCharacterAsNumber * weight[currentIndex % weight.length ];
        }*/
        sum = sum + Character.getNumericValue(userInput.charAt(userInput.length()-1));

        return sum % 10 == 0;
    }

}



