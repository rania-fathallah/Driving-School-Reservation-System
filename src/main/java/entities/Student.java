package entities;

import dao.Studentdao;

public class Student {
    private final long _id;
    private final char permis;
    private final String nom;
    private final String prenom;
    private Boolean codeTestResult = false;
    private Boolean drivingTestResult = false;
    private Double total = Double.valueOf(0);
    private Double paid = Double.valueOf(0);


    //CREATING AN INSTANCE OF CLASS STUDENT BUT BY LETTING THE FIELDS TOTAL AND PAID STAY AT THEIR //
    //ORIGINAL VALUE OF 0//
    //USED WHEN THE STUDENT DIDNT HAVE LESSONS YET//
    public Student(long numCin, char permis, String nom, String prenom) {
        this._id = numCin;
        this.permis = permis;
        this.nom = nom;
        this.prenom = prenom;
    }

    //CREATING AN INSTANCE OF CLASS STUDENT BUT WITH CHANGING THE VALUES OF THE FIELDS TOTAL AND PAID//
    //USED WHEN THE STUDENT ALREADY HAD A FEW LESSONS NOT PUT IN THE DATABASE//
    public Student(long numCin, char permis, String nom, String prenom, Double total, Double paid) {
        this._id = numCin;
        this.permis = permis;
        this.nom = nom;
        this.prenom = prenom;
        this.total = total;
        this.paid = paid;
    }

    public long getNumCin() {
        return _id;
    }

    public char getPermis() {
        return permis;
    }

    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
        Studentdao.updateStudent(this._id, "total", this.total);
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
        Studentdao.updateStudent(this._id, "total", this.paid);
    }

    public Boolean getCodeTestResult() {
        return codeTestResult;
    }

    public Boolean getDrivingTestResult() {
        return drivingTestResult;
    }

    public void deleteStudent(int numCin) {
        Studentdao.deleteStudent(numCin);
    }
}
