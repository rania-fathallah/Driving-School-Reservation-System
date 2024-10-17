package entities;

public class Exam {
    private Appointment appointment;
    private Student student;
    private String type;

    public Exam(Appointment appointment, Student student, String type) {
        this.appointment = appointment;
        this.student = student;
        this.type = type;
    }
}
