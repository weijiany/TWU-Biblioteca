package com.twu;

import java.io.PrintStream;

public class ConsoleUtil {

    public static PrintStream out = System.out;

    public static void println(Object str) {
        out.println(str);
    }
}
