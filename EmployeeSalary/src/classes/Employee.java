package classes;

public class Employee {
    private String name = "";
    private double basicSalary = 0, totalSalary = 0, totalSell = 0;

    // name start
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // name end

    // basicSalary

    public double getBasicSalary() {
        return this.basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setTotalSell(double totalSell) {
        this.totalSell = totalSell;
    }

    public double getTotalSalary() {
        double bonus = 0;

        if (this.totalSell >= 200000) {
            bonus = totalSell * 0.2;
        } else if (this.totalSell >= 150000) {
            bonus = totalSell * 0.15;
        } else if (this.totalSell >= 100000) {
            bonus = totalSell * 0.10;
        }
        totalSalary = basicSalary + bonus;

        return this.totalSalary;
    }

}