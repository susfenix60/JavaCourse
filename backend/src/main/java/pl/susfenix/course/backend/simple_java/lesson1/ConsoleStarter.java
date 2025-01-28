package pl.susfenix.course.backend.simple_java.lesson1;

import java.util.Scanner;

public class ConsoleStarter {
    public static void main(String[] args) {
        startCalculator();
    }

    public static void startCalculator() {

        // Skaner to przyjmowanie informacji od użytkownika \\
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Calculator has started");

        int chosenOption = -1;
        while (chosenOption != 0) {  //while - dopóki warunek jest prawdziwy/zgadza się\\

            showMenu();
            chosenOption = scanner.nextInt();
            if (chosenOption == 1) {
                doAddOperation(scanner);
            }
            if (chosenOption == 2) {
                doSubtractOperation(scanner);
            }
        }
        //scanner.close();
    }


    private static void showMenu() {
/*        System.out.println(
                """
                        Witaj w aplikacji KALKULATOR
                        Wybierz co chcesz zrobić:
                        1.Dodaj liczby
                        2.Odejmij liczby
                        3.Podziel liczby
                        4.Pomnóż liczby
                        5.Potęguj liczby
                        6.Wykonaj dzielenie z resztą
                        0.Wyjście
                                      
                        WYBIERZ OPCJE:
                        """
        );*/
    }

    private static void doAddOperation(Scanner scanner) {

        System.out.print("Podaj pierwszą liczbe: ");
        double firstUserNumber = scanner.nextDouble();

        System.out.print("Podaj drugą liczbe: ");
        double secondUserNumber = scanner.nextDouble();

        double added = SimpleCalculator.add(firstUserNumber, secondUserNumber);

        System.out.println("Wynik to: " + added);

    }

    private static void doSubtractOperation(Scanner scanner) {

        System.out.print("Podaj pierwszą liczbe: ");
        double firstUserNumber = scanner.nextDouble();

        System.out.print("Podaj drugą liczbe: ");
        double secondUserNumber = scanner.nextDouble();

        double substracted = SimpleCalculator.substract(firstUserNumber, secondUserNumber);

        System.out.println("Wynik = " + substracted);
    }
}
