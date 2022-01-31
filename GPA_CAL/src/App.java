import java.util.ArrayList;
import java.util.Scanner;

import classFile.Menu;
import classFile.Student;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();

        int idNum = 1;

        while (true) {
            byte choice;
            Menu.showMenu();
            choice = scanner.nextByte();

            if (choice == 1) {
                Student stu = new Student();
                stu.setIdNumber(idNum);
                idNum++;
                double marks, totalCredit = 0, credit, creditXpoint = 0, point;
                int subjects, i;

                System.out.println("Enter name of the student. ");
                String stuName;
                scanner.nextLine();
                stuName = scanner.nextLine();

                stu.setName(stuName.toUpperCase());
                // scanner.next();

                System.out.println("Enter number of subjects : ");
                subjects = scanner.nextInt();

                for (i = 0; i < subjects; i++) {
                    System.out.println("Enter mark ");
                    marks = scanner.nextDouble();
                    System.out.println("Enter credit of the subject ");
                    credit = scanner.nextDouble();
                    totalCredit += credit;
                    if (marks >= 80) {
                        point = 4.0;
                    } else if (marks >= 75) {
                        point = 3.75;
                    } else if (marks >= 70) {
                        point = 3.5;
                    } else if (marks >= 65) {
                        point = 3.25;
                    } else if (marks >= 60) {
                        point = 3.0;
                    } else if (marks >= 55) {
                        point = 2.75;
                    } else if (marks >= 50) {
                        point = 2.5;
                    } else if (marks >= 45) {
                        point = 2.25;
                    } else if (marks >= 40) {
                        point = 2.00;
                    } else {
                        point = 0.00;
                    }
                    creditXpoint += (credit * point);
                }
                if ((creditXpoint / totalCredit) >= 2) {
                    stu.setGpa(creditXpoint / totalCredit);
                } else {
                    stu.setGpa(0.00);
                }
                students.add(stu);
                System.out.println("Data added to the database.\n");
                System.out.println("Student id number is " + stu.getIdNumber()
                        + " (Please note the number you'll need the number to see you're result.)");
            } else if (choice == 2) {
                System.out.println("Enter student id number");
                short idNumber;
                idNumber = scanner.nextShort();
                try {
                    Student student = new Student();
                    student = students.get(--idNumber);
                    System.out.println("==============================================");
                    System.out.println("Name " + student.getName());
                    System.out.println("ID Number " + student.getIdNumber());
                    System.out.println("Gpa " + student.getGpa() + " out of 4.00");
                    System.out.println("==============================================");
                } catch (Exception e) {
                    System.out.println("Invalid id number.");
                }
            } else {
                System.out.println("Thx for using the program.");
                break;
            }

        }

        scanner.close();
    }
}
