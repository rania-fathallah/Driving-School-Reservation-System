package controlers;

import entities.Appointment;
import input.AppointmentInput;

import java.sql.Timestamp;

public class AppointmentControler {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static Appointment createAppointment() {
        String date = AppointmentInput.insertDate();
        try {
            long start = Timestamp.valueOf(date + " " + AppointmentInput.insertStartTime()).getTime();
            long end = Timestamp.valueOf(date + " " + AppointmentInput.insertEndTime()).getTime();
            if (start < end) {
                Appointment a = new Appointment(start, end);
                return (a);
            } else {
                System.out.println("Start time can't be before end time !");
                return (null);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ANSI_RED + "write a possible date:" + ANSI_RESET);
            return (createAppointment());
        }

    }

}
