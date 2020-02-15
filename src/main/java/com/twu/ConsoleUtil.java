package com.twu;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUtil {

    public static PrintStream out = System.out;
    public static Scanner scanner = new Scanner(System.in);

    public static void println(Object str) {
        out.println(str);
    }

    public static String next() {
        return scanner.next();
    }
}
