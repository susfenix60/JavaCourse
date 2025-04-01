package pl.susfenix.course.backend.simple_java.lesson2.object.pesel;

import pl.susfenix.course.backend.simple_java.lesson2.object.pesel.model.PeselData;

import java.time.LocalDate;
import java.util.Scanner;

public class ObjectPeselInformation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your pesel.");
        String userInput = scanner.next();
        scanner.close();

        boolean isValid = PeselValidator.isValid(userInput);
        if (!isValid) {
            System.out.println("Your pesel is incorrect");
            return;
        }
        System.out.println("Your pesel is " + isValid);

        PeselData peselData = PeselExtractor.fromPesel(userInput);
        System.out.println(peselData);

        System.out.println("You are a " + peselData.getGender());
        System.out.println("You were born on " + peselData.getPrettyBirthDate());
        //System.out.println(LocalDate.now());
        System.out.println("Your age yearly is: " + peselData.calculateAgeYearly());
        System.out.println("Your age exactly is: " + peselData.calculateAge());
        //00032187368 - 21.03.1900 ---> age: 125, exactly: 125
        //00032053573 - 20.03.1900 ---> age: 125, exactly: 124
        //00032285424 - 22.03.1900 ---> age: 125, exactly: 124
        //00022849298 - 28.02.1900 ---> age: 125, exactly: 125
        //00041021161 - 10.04.1900 ---> age: 125, exactly: 124

    }
}



