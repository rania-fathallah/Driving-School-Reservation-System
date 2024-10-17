package codecs;

import entities.Appointment;
import entities.Exam;
import entities.Student;
import org.bson.Document;

public class ExamCodec {
    public static Exam convert(Document doc) {
        Appointment appointment = AppointmentCodec.convert((Document) doc.get("appointment"));
        Student student = StudentCodec.convert((Document) doc.get("student"));
        String type = String.valueOf(doc.get("type"));
        Exam e = new Exam(appointment, student, type);
        return (e);
    }
}
