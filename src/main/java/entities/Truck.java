package entities;

public class Truck extends Vehicle {
    public Truck(long _id, long dateMiseInService) {
        super(_id, dateMiseInService, "Truck");
    }

    public Truck(long _id, long dateMiseInService, long kilom, long kilomReste) {
        super(_id, dateMiseInService, "Truck", kilom, kilomReste);
    }
}
