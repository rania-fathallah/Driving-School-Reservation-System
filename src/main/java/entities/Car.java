package entities;

public class Car extends Vehicle {
    public Car(long _id, long dateMiseInService) {
        super(_id, dateMiseInService, "Car");
    }

    public Car(long _id, long dateMiseInService, long kilom, long kilomReste) {
        super(_id, dateMiseInService, "Car", kilom, kilomReste);
    }
}
