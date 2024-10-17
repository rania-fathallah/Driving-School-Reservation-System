package dao;

import codecs.VehicleCodec;
import com.google.gson.Gson;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import entities.Vehicle;
import input.VehicleInput;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.NoSuchElementException;
import java.util.Vector;

import static com.mongodb.client.model.Filters.eq;

public class Vehicledao {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    final static MongoDatabase database = mongoClient.getDatabase("miniProject");
    final static MongoCollection<Document> collection = database.getCollection("vehicles");
    final static Gson gson = new Gson();


    public static Vehicle searchVehicle(long numImmatriculation) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numImmatriculation)).cursor();
        if (cursor.hasNext()) {
            System.out.println("The vehicle is already registered !");
            Vehicle v = VehicleCodec.convert(cursor.next());
            return (v);
        } else {
            System.out.println("The vehicle isn't registered !");
            System.out.println("");
            return (null);
        }
    }

    public static void insertVehicle(Vehicle v) {
        try {
            collection.insertOne(Document.parse(gson.toJson(v)));
            try {
                collection.updateOne(eq("_id", 0), Updates.set("nombreDeVehicule", (int) ((collection.find(eq("_id", 0)).cursor().next()).get("nombreDeVehicule")) + 1));
            } catch (NoSuchElementException exe) {
                collection.insertOne(new Document()
                        .append("_id", 0)
                        .append("nombreDeVehicule", 1)
                );
            }
        } catch (MongoWriteException ex) {
            System.out.println(VehicleInput.ANSI_RED + "The vehicle is already registered." + VehicleInput.ANSI_RESET);
        }
    }

    public static void deleteVehicule(long numImmatriculation) {
        Bson filter = eq("_id", numImmatriculation);
        collection.deleteOne(filter);
        try {
            collection.updateOne(eq("_id", 0), Updates.set("nombreDeVehicule", (int) ((collection.find(eq("_id", 0)).cursor().next()).get("nombreDeVehicule")) - 1));
        } catch (NoSuchElementException exe) {
            collection.insertOne(new Document()
                    .append("_id", 0)
                    .append("nombreDeVehicule", 0)
            );
        }

    }

    public static void updateVehicule(long numImmatriculation, String whatToUpdate, long value) {
        collection.updateOne(eq("_id", numImmatriculation), Updates.set(whatToUpdate, value));
    }

    public static Vector<Vehicle> getVehicles(String by) {
        Bson filter = Filters.and(Filters.gt("_id", 0), Filters.eq("type", by));
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        Vector<Vehicle> v = new Vector<>();
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                v.add(VehicleCodec.convert(cursor.next()));
            }
            return v;
        } else {
            System.out.println("No vehicle is registered !");
            System.out.println("");
            return (null);
        }
    }

    public static int nombreDeVehicule() {
        int x = (int) (collection.find(eq("_id", 0)).cursor().next()).get("nombreDeVehicule");
        return (x);
    }

    public static Vector<Vehicle> getVehicles() {
        Bson filter = Filters.gt("_id", 0);
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        Vector<Vehicle> v = new Vector<>();
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                v.add(VehicleCodec.convert(cursor.next()));
            }
            return v;
        } else {
            System.out.println("No vehicle registered !");
            System.out.println("");
            return (null);
        }
    }
}
