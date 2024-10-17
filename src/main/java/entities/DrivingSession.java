package entities;

public class DrivingSession extends Session {
    private Vehicle vehicle;

    public DrivingSession(Appointment appointment, Vehicle vehicle, Engineer engineer, Student student) {
        super(appointment, engineer, student, "Driving");
        this.vehicle = vehicle;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
