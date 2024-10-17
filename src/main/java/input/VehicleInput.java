package input;

import entities.Engineer;
import entities.Vehicle;

import java.sql.Timestamp;
import java.util.Scanner;
import java.util.Vector;


public class VehicleInput {
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

    public static long insertnumImmatriculation() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the immatriculation number of the vehicle :" + ANSI_RESET);
        return (sc.nextLong());
    }

    public static long insertDateMiseInService() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the date this vehicle was put in service :" + ANSI_RESET);
        System.out.println("Give the day :");
        int day = sc.nextInt();
        System.out.println("Give the month :");
        int month = sc.nextInt();
        System.out.println("Give the year :");
        int year = sc.nextInt();
        String date = year + "-" + month + "-" + day;
        long dateMiseEnService = Timestamp.valueOf(date + " " + "00:00:00").getTime();
        return (dateMiseEnService);
    }

    public static long insertKilom() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Write the number of kilometre this vehicle have :" + ANSI_RESET);
        return (sc.nextLong());
    }

    public static String insertType() {
        sc.nextLine();
        System.out.println(ANSI_CYAN + "Which type of vehicle do you want to add :" + ANSI_RESET);
        System.out.println("1- a car .\n" + "2- a truck .\n" + "3- a motorcycle .\n");
        System.out.println("Choose a number :");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                return ("car");
            case 2:
                return ("truck");
            case 3:
                return ("motorcycle");
            default:
                return ("something");
        }
    }

    public static String whatToUpdate() {
        sc.nextLine();
        System.out.println(ANSI_GREEN + "What do you want to update :" + ANSI_RESET);
        return (sc.nextLine().toUpperCase().strip());
    }

    public static void printVehicules(Vector<Vehicle> v) {
        for (int j = 0; j < v.size(); j++) {
            System.out.println(j + "_ The vehicle " + v.get(j).get_id() + " .");
        }
    }

}
