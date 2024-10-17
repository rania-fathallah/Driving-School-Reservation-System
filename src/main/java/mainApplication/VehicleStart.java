package mainApplication;

import controlers.VehicleControler;

import java.util.Scanner;

public class VehicleStart {
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
            System.out.println(ANSI_BLUE + "1-Add vehicle.");
            System.out.println("2-Remove Vehicle.");
            System.out.println("3-Get vehicle.");
            System.out.println("4-Print the whole list.");
            System.out.println("OTHER : Go Back To Start Menu ." + ANSI_RESET);
            System.out.print(ANSI_RED + "->" + ANSI_RESET);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    VehicleControler.addVehicle();
                    break;
                case 2:
                    VehicleControler.removeVehicle();
                    break;
                case 3:
                    VehicleControler.getVehicle();
                    break;
                case 4:
                    VehicleControler.printVehicles();
                    break;
                default:
                    Start.start();
            }
        }
    }
}
