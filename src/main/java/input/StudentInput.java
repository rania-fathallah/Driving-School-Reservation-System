package input;

import java.awt.*;
import java.util.Scanner;

public class StudentInput {
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

    public static String insertNom() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the first name of the student :" + ANSI_RESET);
        return (sc.nextLine());
    }

    public static long insertCin() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the CIN number of the student :" + ANSI_RESET);
        return (sc.nextLong());
    }

    public static String insertPrenom() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the last name of the student :" + ANSI_RESET);
        return (sc.nextLine());
    }

    public static char insertpermis() {
        sc.nextLine();
        char type = ' ';
        while (Character.compare(type, 'a') != 0 && Character.compare(type, 'A') != 0 && Character.compare(type, 'b') != 0 && Character.compare(type, 'B') != 0 && Character.compare(type, 'c') != 0 && Character.compare(type, 'C') != 0) {
            System.out.println(ANSI_CYAN + "Write the permit type :" + ANSI_RESET);
            type = sc.next().charAt(0);
        }
        return (Character.toUpperCase(type));
    }

    public static String whatToUpdate() {
        sc.nextLine();
        System.out.println(ANSI_GREEN + "What do you want to update :" + ANSI_RESET);
        return (sc.nextLine());
    }

    public static double insertpaid() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write how much paid  :" + ANSI_RESET);
        return (sc.nextDouble());
    }
}
