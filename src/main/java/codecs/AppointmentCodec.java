package codecs;

import entities.Appointment;

import org.bson.Document;

public class AppointmentCodec {

    public static Appointment convert(Document doc) {
        String startS = String.valueOf(doc.get("start"));
        Long start = Long.parseLong(startS);
        String endS = String.valueOf(doc.get("end"));
        Long end = Long.parseLong(endS);
        Appointment appointment = new Appointment(start, end);
        return (appointment);
    }
}
