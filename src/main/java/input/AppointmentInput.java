package input;

import java.util.Scanner;

public class AppointmentInput {
    static Scanner sc = new Scanner(System.in);

    public static String insertDate() {
        System.out.println("Give the day :");
        int day = sc.nextInt();
        System.out.println("Give the month :");
        int month = sc.nextInt();
        System.out.println("Give the year :");
        int year = sc.nextInt();
        String date = year + "-" + month + "-" + day;
        return (date);
    }

    public static String insertStartTime() {
        System.out.println("give the start hour :");
        int hour = sc.nextInt();
        System.out.println("give the start minute :");
        int minute = sc.nextInt();
        String time = hour + ":" + minute + ":00";
        return (time);
    }

    public static String insertEndTime() {
        System.out.println("Give the end hour :");
        int hour = sc.nextInt();
        System.out.println("Give the end minute :");
        int minute = sc.nextInt();
        String time = hour + ":" + minute + ":00";
        return (time);
    }
}
