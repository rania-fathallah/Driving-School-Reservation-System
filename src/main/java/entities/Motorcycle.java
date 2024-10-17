package entities;

public class Motorcycle extends Vehicle{
    public Motorcycle(long _id, long dateMiseInService) {
        super(_id, dateMiseInService,"Motorcycle");
    }
    public Motorcycle(long _id, long dateMiseInService, long kilom, long kilomReste) {
        super(_id, dateMiseInService, "Motorcycle", kilom, kilomReste);
    }
}
