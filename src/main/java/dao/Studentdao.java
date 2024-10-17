package dao;

import codecs.StudentCodec;
import com.google.gson.Gson;
import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entities.Student;
import input.StudentInput;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Vector;

import static com.mongodb.client.model.Filters.eq;

public class Studentdao {
    final static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    final static MongoDatabase database = mongoClient.getDatabase("miniProject");
    final static MongoCollection<Document> collection = database.getCollection("students");
    final static Gson gson = new Gson();

    public static Student searchStudent(long numCin) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numCin)).cursor();
        if (cursor.hasNext()) {
            System.out.println("The student is already registered !");
            Student s = StudentCodec.convert(cursor.next());
            return (s);
        } else {
            System.out.println("The student isn't registered !");
            System.out.println("");
            return (null);
        }
    }


    public static void insertStudent(Student s) {
        try {
            collection.insertOne(Document.parse(gson.toJson(s)));
        } catch (MongoWriteException e) {
            System.out.println(StudentInput.ANSI_RED + "The student is already registered." + StudentInput.ANSI_RESET);
        }
    }

    public static Double searchStudentFieldPaid(long numCin) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numCin)).cursor();
        if (cursor.hasNext()) {
            Double paid = StudentCodec.getPaid(cursor.next());
            return (paid);
        } else {
            System.out.println("The student isn't registered !");
            return (null);
        }
    }

    public static Double searchStudentFieldTotal(long numCin) {
        MongoCursor<Document> cursor = collection.find(eq("_id", numCin)).cursor();
        if (cursor.hasNext()) {
            Double total = StudentCodec.getTotal(cursor.next());
            return (total);
        } else {
            System.out.println("The student isn't registered !");
            return (null);
        }
    }

    public static void deleteStudent(long numCin) {
        Bson filter = eq("_id", numCin);
        collection.deleteOne(filter);
    }

    public static void updateStudent(long numCin, String whatToUpdate, double value) {
        collection.updateOne(eq("_id", numCin), Updates.set(whatToUpdate, value));
    }

    public static Vector<Student> getStudents() {
        Bson filter = Filters.gt("_id", 0);
        MongoCursor<Document> cursor = collection.find(filter).cursor();
        Vector<Student> v = new Vector<>();
        if (cursor.hasNext()) {
            while (cursor.hasNext()) {
                v.add(StudentCodec.convert(cursor.next()));
            }
            return v;
        } else {
            System.out.println("No student registered !");
            System.out.println("");
            return (null);
        }
    }
}
