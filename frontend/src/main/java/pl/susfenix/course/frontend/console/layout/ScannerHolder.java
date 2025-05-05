package pl.susfenix.course.frontend.console.layout;

import java.util.Scanner;

public class ScannerHolder {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner(){
        return SCANNER;
    }
    public static void close(){
        SCANNER.close();
    }

}

