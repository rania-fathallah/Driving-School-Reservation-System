package codecs;

import entities.*;
import org.bson.Document;

public class SessionCodec {

    public static Session convert(Document doc){
        Session s;
        Appointment appointment = AppointmentCodec.convert((Document) doc.get("appointment"));
        Student student = StudentCodec.convert((Document) doc.get("student"));
        Engineer engineer = EngineerCodec.convert((Document) doc.get("engineer"));
        String type = String.valueOf(doc.get("type"));
        if (type.equalsIgnoreCase("Code")) {
           s=new CodeSession(appointment,engineer,student);
        }else{
            Vehicle vehicle =VehicleCodec.convert((Document) doc.get("vehicle"));
            s=new DrivingSession(appointment,vehicle,engineer,student);
        }
        return(s);
    }

    public static DrivingSession convertD(Document doc){
        DrivingSession s;
        Appointment appointment=AppointmentCodec.convert((Document) doc.get("appointment"));
        Student student =StudentCodec.convert((Document) doc.get("student"));
        Engineer engineer =EngineerCodec.convert((Document) doc.get("engineer"));
        String type =String.valueOf(doc.get("type"));
        Vehicle vehicle =VehicleCodec.convert((Document) doc.get("vehicle"));
        s=new DrivingSession(appointment,vehicle,engineer,student);
        return(s);
    }
}
