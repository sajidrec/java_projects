package classFile;

public class Student {
    private String name;
    private int idNumber;
    private double gpa;

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }
}
