package pl.susfenix.course.backend.simple_java.codingBat;

//Return true if the given non-negative number is 1 or 2 more than a multiple of 20.

public class More20 {

    public static void main(String[] args){

        assert more20(20) == false;
        assert more20(21) == true;
        assert more20(22) == true;

        System.out.println(more20(2));
    }

    public static boolean more20(int n) {

        if (n <= 20) return false;
        return n % 20 == 1 || n % 20 == 2;

    }
}