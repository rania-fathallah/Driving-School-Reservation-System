package codecs;

import entities.Car;
import entities.Motorcycle;
import entities.Truck;
import entities.Vehicle;
import org.bson.Document;

public class VehicleCodec {
    public static Vehicle convert(Document doc) {
        String numCinS = String.valueOf(doc.get("_id"));
        long numImmatriculation = Long.parseLong(numCinS);
        String dateMiseInServiceS = String.valueOf(doc.get("dateMiseInService"));
        long dateMiseInService = Long.parseLong(dateMiseInServiceS);
        String kilomS = String.valueOf(doc.get("kilom"));
        long kilom = Long.parseLong(kilomS);
        String kilomResteS = String.valueOf(doc.get("kilomReste"));
        long kilomReste = Long.parseLong(kilomResteS);
        if (doc.get("type").toString().equalsIgnoreCase("car")) {
            Vehicle v = new Car(numImmatriculation, dateMiseInService, kilom, kilomReste);
            return (v);
        } else {
            if (doc.get("type").toString().equalsIgnoreCase("Motorcycle")) {
                Vehicle v = new Motorcycle(numImmatriculation, dateMiseInService, kilom, kilomReste);
                return (v);
            } else {
                if (doc.get("type").toString().equalsIgnoreCase("Truck")) {
                    Vehicle v = new Truck(numImmatriculation, dateMiseInService, kilom, kilomReste);
                    return (v);
                }
            }
        }
        return (null);
    }

    public static long getKilom(Document doc) {
        String kilom = String.valueOf(doc.get("skilom"));
        return (Long.parseLong(kilom));
    }

}
