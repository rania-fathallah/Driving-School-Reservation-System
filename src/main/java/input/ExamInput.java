package input;

import java.util.Scanner;

public class ExamInput {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static Scanner sc = new Scanner(System.in);

    public static int test() {
        System.out.println("Student doesn't exist .");
        System.out.println("write :\n(0) if you want to try again.\n(1) if you dont want to");
        return (sc.nextInt());
    }

    public static int test1() {
        System.out.println("The appointment wasnt created .");
        System.out.println("write :\n(0) if you want to try again.\n(1) if you dont want to");
        return (sc.nextInt());
    }

    public static void test2() {
        System.out.println("il y'a un examen deja .");

    }
}
