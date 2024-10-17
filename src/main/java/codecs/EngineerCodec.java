package codecs;

import entities.Engineer;
import org.bson.Document;

public class EngineerCodec {

    public static Engineer convert(Document doc) {
        String numCinS = String.valueOf(doc.get("_id"));
        Long numCin = Long.parseLong(numCinS);
        String salaryS = String.valueOf(doc.get("salary"));
        double salary = Double.parseDouble(salaryS);
        Engineer e = new Engineer(numCin, doc.get("nom").toString(), doc.get("prenom").toString(), salary);
        return (e);
    }

    public static double getSalary(Document doc) {
        String salary = String.valueOf(doc.get("salary"));
        return (Double.parseDouble(salary));
    }


}
