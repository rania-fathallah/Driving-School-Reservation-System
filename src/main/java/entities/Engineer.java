package entities;

public class Engineer {
    private final long _id;
    private final String nom;
    private final String prenom;
    private Double salary = Double.valueOf(0);

    public Engineer(long _id, String nom, String prenom) {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Engineer(long _id, String nom, String prenom, Double salary) {
        this._id = _id;
        this.nom = nom;
        this.prenom = prenom;
        this.salary = salary;
    }

    public long get_id() {
        return _id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
