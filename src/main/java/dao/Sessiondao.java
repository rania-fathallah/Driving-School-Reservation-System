package dao;

import codecs.SessionCodec;
import com.google.gson.Gson;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import entities.Appointment;
import entities.Session;
import input.EngineerInput;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Vector;

public class Sessiondao {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    final static MongoDatabase database = mongoClient.getDatabase("miniProject");
    final static MongoCollection<Document> collection = database.getCollection("sessions");
    final static Gson gson = new Gson();

    public static void insertSession(Session s) {
        try {
            collection.insertOne(Document.parse(gson.toJson(s)));
        } catch (MongoWriteException ex) {
            System.out.println(EngineerInput.ANSI_RED + "The session already exist." + EngineerInput.ANSI_RESET);
        }
    }

    public static MongoCursor<Document> findSessions(Appointment appointment) {
        Bson filter = Filters.or(Filters.and(Filters.gte("appointment.start", appointment.getStartl()), Filters.lte("appointment.end", appointment.getEndl())), Filters.and(Filters.lte("appointment.start", appointment.getStartl()), Filters.gt("appointment.end", appointment.getStartl())), Filters.and(Filters.lt("appointment.start", appointment.getEndl()), Filters.gte("appointment.end", appointment.getEndl())));
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        return (cursor);
    }

    public static MongoCursor<Document> findDrivingSessions(Appointment appointment) {
        Bson filter = Filters.and(Filters.or(Filters.and(Filters.gte("appointment.start", appointment.getStartl()), Filters.lte("appointment.end", appointment.getEndl())), Filters.and(Filters.lte("appointment.start", appointment.getStartl()), Filters.gt("appointment.end", appointment.getStartl())), Filters.and(Filters.lt("appointment.start", appointment.getEndl()), Filters.gte("appointment.end", appointment.getEndl()))), Filters.eq("type", "Driving"));
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        return (cursor);
    }

    public static Vector<Session> getSessions(long CIN) {
        Bson filter = Filters.eq("Student._id", CIN);
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        Vector<Session> v = new Vector<>();
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                v.add(SessionCodec.convert(cursor.next()));
            }
            return v;
        } else {
            System.out.println("No session exist !");
            System.out.println("");
            return (null);
        }
    }

}
