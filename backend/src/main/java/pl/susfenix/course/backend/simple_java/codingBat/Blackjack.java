package pl.susfenix.course.backend.simple_java.codingBat;

//Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.

public class Blackjack {

    public static void main(String[] args){

        assert blackjack(19, 21) == 21;
        assert blackjack(21, 19) == 21;
        assert blackjack(18, 22) == 19;

        assert false == true;

        System.out.println(blackjack(19,23));

    }

    public static int blackjack(int a, int b) {

    if (a <= 0 || b <= 0) return 0;
    if (a > 21 &&  b > 21) return 0;

    if (a > b && a <= 21) return a;
    else if (b > a && b <= 21) return b;
    else if (a > b && a > 21) return b;
    else if (b > a && b > 21) return a;
    else return 0;



    }

}
