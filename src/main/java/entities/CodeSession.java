package entities;

public class CodeSession extends Session {

    public CodeSession(Appointment appointment, Engineer engineer, Student student) {
        super(appointment, engineer, student, "Code");
    }
}
