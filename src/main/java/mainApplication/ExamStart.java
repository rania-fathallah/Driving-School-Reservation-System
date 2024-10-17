package mainApplication;

import controlers.ExamControler;

import java.util.Scanner;

public class ExamStart {
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

    static void start() {
        while (true) {
            System.out.println(ANSI_YELLOW + "Choose the number of the thing you want to access :" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1-Add an exam.");
            System.out.println("2-Get Exam.");
            System.out.println("OTHER : Go Back To Start Menu ." + ANSI_RESET);
            System.out.print(ANSI_RED + "->" + ANSI_RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ExamControler.addExam();
                    break;
                case 2:
                    ExamControler.getExam();
                    break;
                default:
                    Start.start();
            }
        }
    }
}
