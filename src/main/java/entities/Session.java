package entities;

public class Session {
    private Appointment appointment;
    private Engineer engineer;
    private Student student;
    private String type;

    public Session(Appointment appointment, Engineer engineer, Student student, String type) {
        this.appointment = appointment;
        this.engineer = engineer;
        this.student = student;
        this.type = type;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Engineer getEngineer() {
        return engineer;
    }

    public Student getStudent() {
        return student;
    }

    public String getType() {
        return type;
    }
}
