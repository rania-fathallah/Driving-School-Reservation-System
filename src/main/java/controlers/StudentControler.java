package controlers;

import dao.Studentdao;
import entities.Student;
import input.StudentInput;

import java.util.Vector;

public class StudentControler {
    //SEARCHING FOR A STUDENT IN THE DATABASE AND RETURNING IT AS A INSTANCE OF CLASS STUDENT//
    public static Student getStudent() {
        Student s = Studentdao.searchStudent(StudentInput.insertCin());
        return (s);
    }

    public static void removeStudent(long numCin) {
        Studentdao.deleteStudent(numCin);
    }

    //ADDING A STUDENT TO THE DATABASE//
    public static void addStudent() {
        Studentdao.insertStudent(new Student(StudentInput.insertCin(), StudentInput.insertpermis(), StudentInput.insertNom(), StudentInput.insertPrenom()));
    }

    //DELETE A STUDENT FROM THE DATABASE BY INPUTTING THE CIN NUMBER OF THE PERSON YOUR WANT TO DELETE//
    public static void removeStudent() {
        Studentdao.deleteStudent(StudentInput.insertCin());
    }

    //ADD THE INPUT NUMBER TO THE TOTAL PAID VALUE ALREADY IN THE DATABASE OF THE STUDENT WITH THAT//
    //CIN NUMBER AFTER INSERTING IT//
    public static void updateStudentpaid() {
        long numCin = StudentInput.insertCin();
        try {
            Studentdao.updateStudent(numCin, "paid", StudentInput.insertpaid() + Studentdao.searchStudentFieldPaid(numCin));
        } catch (NullPointerException ex) {
        }
    }

    //ADD THE INPUT FOR THE NEED TO PAY VALUE AND THE ALREADY SAVED PRICE IN THE DATABASE //
    //TO GET THE TOTAL PRICE FOR THE STUDENT WITH THAT CIN NUMBER //
    public static void updateStudenttotal(long numCin, Double toPay) {
        try {
            Studentdao.updateStudent(numCin, "total", toPay + Studentdao.searchStudentFieldTotal(numCin));
        } catch (NullPointerException ex) {
        }
    }


    public static void printStudents() {
        Vector<Student> v = Studentdao.getStudents();
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }

}
