package controlers;

import dao.Engineerdao;
import entities.Engineer;
import input.EngineerInput;

import java.util.Vector;


public class EngineerControler {

    //ADDING AN ENGINEER TO THE DATABASE//
    public static void addEngineer() {
        Engineerdao.insertEngineer(new Engineer(EngineerInput.insertCin(), EngineerInput.insertNom(), EngineerInput.insertPrenom()));
    }

    //DELETE AN ENGINEER FROM THE DATABASE BY INPUTTING THE CIN NUMBER OF THE PERSON YOUR WANT TO DELETE//
    public static void removeEngineer() {
        Engineerdao.deleteEngineer(EngineerInput.insertCin());
    }

    public static Engineer getEngineer() {
        Engineer s = Engineerdao.searchEngineer(EngineerInput.insertCin());
        return (s);
    }

    //ADD THE INPUT NUMBER TO THE TOTAL SALARY VALUE ALREADY IN THE DATABASE OF THE ENGINEER WITH THAT//
    //CIN NUMBER AFTER INSERTING IT//
    public static void updateEngineerSalary(long numCin, double salary) {
        try {
            Engineerdao.updateEngineer(numCin, "salary", salary + Engineerdao.searchEngineerFieldSalary(numCin));
        } catch (NullPointerException ex) {
        }
    }

    public static void printENgineers() {
        Vector<Engineer> v = Engineerdao.getEngineers();
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }

}
