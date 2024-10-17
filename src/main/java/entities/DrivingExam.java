package entities;

public class DrivingExam extends Exam {
    private Vehicle vehicle;
    private Engineer engineer;

    public DrivingExam(Appointment appointment, Student student, Vehicle vehicle, Engineer engineer) {
        super(appointment, student, "Driving");
        this.vehicle = vehicle;
        this.engineer = engineer;
    }

}
