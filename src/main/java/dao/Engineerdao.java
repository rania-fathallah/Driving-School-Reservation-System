package dao;

import codecs.EngineerCodec;
import com.google.gson.Gson;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entities.Engineer;


import input.EngineerInput;
import org.bson.Document;
import org.bson.conversions.Bson;


import java.util.NoSuchElementException;
import java.util.Vector;

import static com.mongodb.client.model.Filters.eq;

public class Engineerdao {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    final static MongoDatabase database = mongoClient.getDatabase("miniProject");
    final static MongoCollection<Document> collection = database.getCollection("engineer");
    final static Gson gson = new Gson();

    public static Engineer searchEngineer(long numCin) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numCin)).cursor();
        if (cursor.hasNext()) {
            System.out.println("The Engineer is already registered !");
            Engineer e = EngineerCodec.convert(cursor.next());
            return (e);
        } else {
            System.out.println("The engineer isn't registered !");
            System.out.println("");
            return (null);
        }
    }

    public static void insertEngineer(Engineer e) {
        try {
            collection.insertOne(Document.parse(gson.toJson(e)));
            try {
                collection.updateOne(eq("_id", 0), Updates.set("nombreD'ingenieur", (int) ((collection.find(eq("_id", 0)).cursor().next()).get("nombreD'ingenieur")) + 1));
            } catch (NoSuchElementException exe) {
                collection.insertOne(new Document()
                        .append("_id", 0)
                        .append("nombreD'ingenieur", 1)
                );
            }
        } catch (MongoWriteException ex) {
            System.out.println(EngineerInput.ANSI_RED + "The engineer is already registered." + EngineerInput.ANSI_RESET);
        }
    }

    public static Double searchEngineerFieldSalary(long numCin) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numCin)).cursor();
        if (cursor.hasNext()) {
            Double salary = EngineerCodec.getSalary(cursor.next());
            return (salary);
        } else {
            System.out.println("The engineer isn't registered !");
            return (null);
        }
    }

    public static void deleteEngineer(long numCin) {
        Bson filter = eq("_id", numCin);
        collection.deleteOne(filter);
        try {
            collection.updateOne(eq("_id", 0), Updates.set("nombreD'ingenieur", (int) ((collection.find(eq("_id", 0)).cursor().next()).get("nombreD'ingenieur")) - 1));
        } catch (NoSuchElementException exe) {
            collection.insertOne(new Document()
                    .append("_id", 0)
                    .append("nombreDeVehicule", 0)
            );
        }
    }

    public static void updateEngineer(long numCin, String whatToUpdate, double value) {
        collection.updateOne(eq("_id", numCin), Updates.set(whatToUpdate, value));
    }

    public static int nombreIngenieur() {
        int x = (int) (collection.find(eq("_id", 0)).cursor().next()).get("nombreD'ingenieur");
        return (x);
    }

    public static Vector<Engineer> getEngineers() {
        Bson filter = Filters.gt("_id", 0);
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        Vector<Engineer> v = new Vector<>();
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                v.add(EngineerCodec.convert(cursor.next()));
            }
            return v;
        } else {
            System.out.println("No engineer registered !");
            System.out.println("");
            return (null);
        }
    }


}
