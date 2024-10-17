package dao;

import codecs.ExamCodec;
import com.google.gson.Gson;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import entities.Exam;
import input.StudentInput;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Examdao {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    final static MongoDatabase database = mongoClient.getDatabase("miniProject");
    final static MongoCollection<Document> collection = database.getCollection("exams");
    final static Gson gson = new Gson();

    public static void insertExam(Exam e) {
        try {
            collection.insertOne(Document.parse(gson.toJson(e)));
        } catch (MongoWriteException ex) {
            System.out.println(StudentInput.ANSI_RED + "." + StudentInput.ANSI_RESET);
        }
    }

    public static Exam searchExam(long numCin) {
        Bson filter = Filters.and(Filters.eq("Student._id", numCin), Filters.gt("appointment.end", Timestamp.valueOf(LocalDateTime.now()).getTime()));
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        if (cursor.hasNext()) {
            System.out.println("There is an exam date !");
            Exam e = ExamCodec.convert(cursor.next());
            return (e);
        } else {
            System.out.println("There isn't an exam date !");
            System.out.println("");
            return (null);
        }
    }
}
