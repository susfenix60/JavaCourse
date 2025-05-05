package pl.susfenix.course.frontend.console;

import pl.susfenix.course.backend.game.tictactoe.TicTacToe;
import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeApi;
import pl.susfenix.course.backend.simple_java.lesson1.*;
import pl.susfenix.course.backend.simple_java.lesson2.CollectionTesting;
import pl.susfenix.course.frontend.console.game.lotto.LottoConsole;
import pl.susfenix.course.frontend.console.game.tictactoe.TicTacToeConsole;
import pl.susfenix.course.frontend.console.layout.ScannerHolder;

import java.util.Scanner;

public class ConsoleStarter {

    public static void start() {
        Scanner scanner = ScannerHolder.getScanner();
        int userOption = -1;
        while (userOption != 0) {
            System.out.print("""
                     Witaj, wybierz program do odpalenia:
                     
                     0.Wyjście z programu
                     1.Helloworld
                     2.PalindromResolver
                     3.SimpleCalculator
                     4.StringAsciManipulation
                     5.StringFunner
                     6.CollectionTesting
                     7.Lotto
                     8.TicTacToe
                     
                    Twój wybór:  
                     """);
            userOption = scanner.nextInt();
            switch (userOption) {
                case 0: {
                    break;
                }
                case 1: {
                    Helloworld.main(null);
                    break;
                }
                case 2: {
                    PalindromResolver.main(null);
                    break;
                }
                case 3: {
                    SimpleCalculator.main(null);
                    break;
                }
                case 4: {
                    StringAsciManipulation.main(null);
                    break;
                }
                case 5: {
                    StringFunner.main(null);
                    break;
                }
                case 6: {
                    CollectionTesting.main(null);
                    break;
                }
                case 7: {
                    LottoConsole.start();
                    break;
                }
                case 8: {
                    TicTacToeConsole ticTacToeConsole = new TicTacToeConsole();
                    ticTacToeConsole.start();
                    break;
                }


                default:
                    System.out.print("Wybrano błędną opcję.");
            }
        }
        ScannerHolder.close();
    }
}
