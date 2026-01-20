package lahoylahoystudentgrades;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id_number;
    double[] grades = new double[3];
    double average;
    String remark;

    void Average() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        average = sum / grades.length;
    }

    void Remarks() {
        if (average >= 90) {
            remark = "Excellent";
        } else if (average >= 80) {
            remark = "Very Good";
        } else if (average >= 70) {
            remark = "Good";
        } else if (average >= 60) {
            remark = "Needs Improvement";
        } else {
            remark = "Fail";
        }
    }
}

public class LahoyLahoyStudentGrades {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 3) {
            System.out.println("==========================================");
            System.out.println("   >>>STUDENT GRADE MANAGEMENT SYSTEM<<< ");
            System.out.println("==========================================");
            System.out.println("\t(1) Add Student");
            System.out.println("\t(2) View All Students");
            System.out.println("\t(3) Exit");
            System.out.println("==========================================");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                viewStudents();
            } else if (choice == 3) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("INVALID");
            }
        }
    }

    static void addStudent() {
        Student std = new Student();

        System.out.print("Enter Student ID: ");
        std.id_number = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        std.name = scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter Grade for Subject" + (i + 1) + ": ");
                double grade = scanner.nextDouble();

                if (grade >= 0 && grade <= 100) {
                    std.grades[i] = grade;
                    break;
                } else {
                    System.out.println("Grade must be between 0 and 100.");
                }
            }
        }
        scanner.nextLine();

        std.Average();
        std.Remarks();
        students.add(std);

        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n-----------------------------------------------------");
        System.out.printf("%-8s %-18s %-10s %-15s\n", "ID", "Name", "Average", "Remark");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%-8s %-18s %-10.2f %-15s\n",
                    s.id_number, s.name, s.average, s.remark);
        }

        System.out.println("-----------------------------------------------------");
    }
}
    

