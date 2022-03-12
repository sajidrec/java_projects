import java.util.Scanner;
import classes.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Employee a = new Employee();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee name : ");

        String name = sc.nextLine();
        a.setName(name);
        // sc.nextDouble();

        System.out.println("Enter employee's basic salary : ");
        double basicSalary = sc.nextDouble();
        a.setBasicSalary(basicSalary);

        System.out.println("Enter employee's total sell amount : ");
        double totalSell = sc.nextDouble();
        a.setTotalSell(totalSell);

        System.out.println(a.getName() + "'s Basic salary is " + a.getBasicSalary() + " and his total salary is "
                + a.getTotalSalary());
    }
}
