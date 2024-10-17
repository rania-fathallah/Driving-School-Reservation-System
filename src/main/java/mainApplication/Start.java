package mainApplication;

import java.util.Scanner;

public class Start {
    static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void start() {
        while (true) {
            System.out.println(ANSI_PURPLE + "WELCOME TO THE APPLICATION ");
            System.out.println(ANSI_YELLOW + "Choose the number of the thing you want to access :" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1-Student.");
            System.out.println("2-Engineer.");
            System.out.println("3-Vehicles.");
            System.out.println("4-Lessons.");
            System.out.println("5-Exams." + ANSI_RESET);
            System.out.print(ANSI_RED + "->" + ANSI_RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    StudentStart.start();
                    break;
                case 2:
                    EngineerStart.start();
                    break;
                case 3:
                    VehicleStart.start();
                    break;
                case 4:
                    SessionStart.start();
                    break;
                case 5:
                    ExamStart.start();
                    break;
                default:
                    break;
            }
        }
    }
}
