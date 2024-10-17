package codecs;

import entities.Student;
import org.bson.Document;

public class StudentCodec {
    public static Student convert(Document doc) {
        String numCinS = String.valueOf(doc.get("_id"));
        Long numCin = Long.parseLong(numCinS);
        String permisS = String.valueOf(doc.get("permis"));
        char permis = permisS.charAt(0);
        String totalS = String.valueOf(doc.get("total"));
        double total = Double.parseDouble(totalS);
        String paidS = String.valueOf(doc.get("paid"));
        double paid = Double.parseDouble(paidS);
        Student s = new Student(numCin, permis, doc.get("nom").toString(), doc.get("prenom").toString(), total, paid);
        return (s);
    }

    public static double getPaid(Document doc){
        String paid = String.valueOf(doc.get("paid"));
        return(Double.parseDouble(paid));
    }
    public static double getTotal(Document doc){
        String total = String.valueOf(doc.get("total"));
        return(Double.parseDouble(total));
    }
    public static char getPermisType(Document doc){
        String permis = String.valueOf(doc.get("permis"));
        return(permis.charAt(0));
    }
}
