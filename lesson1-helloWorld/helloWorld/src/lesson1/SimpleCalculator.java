package lesson1;

public class SimpleCalculator {

    public static void main(String[] args) {

        final double added = add(7.25, 1.92);
        System.out.println("added: = " + added);

        final double substracted = substract(added, 7.1);
        System.out.println("substracted: = " + substracted);

        final double multiplied = multiply(substracted, 6);
        System.out.println("multiplied: = " + multiplied);

        final double divided = divide(18, 3.5);
        System.out.println("divided: = " + divided);

        final double dividedRest = divideRest(15, 4);
        System.out.println("dividedRest: = " + dividedRest);

        final double powered = pow(5, 0);
        System.out.println("powered: = " + powered);


    }

    public static double pow(double firstNumber, int powCounter) {
        if (powCounter == 0) {
            return 1;
        }
        double powResult = firstNumber;
        for (int currentPow = 1; currentPow < powCounter; currentPow = currentPow + 1) {
            powResult = multiply(powResult, firstNumber);
        }


        return powResult;
    }

    public static int divideRest(double firstNumber, double secondNumber) {
        return (int) (firstNumber % secondNumber);
    }

    public static double divide(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }


    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double substract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }


}
