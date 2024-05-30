package com.sms;

import com.sms.dao.StudentDAO;
import com.sms.Student;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        Student student = new Student();
                        student.setName(name);
                        student.setAge(age);
                        student.setGrade(grade);
                        studentDAO.addStudent(student);
                        break;

                    case 2:
                        System.out.print("Enter student ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new grade: ");
                        String newGrade = scanner.nextLine();
                        Student studentToUpdate = new Student();
                        studentToUpdate.setId(idToUpdate);
                        studentToUpdate.setName(newName);
                        studentToUpdate.setAge(newAge);
                        studentToUpdate.setGrade(newGrade);
                        studentDAO.updateStudent(studentToUpdate);
                        break;

                    case 3:
                        System.out.print("Enter student ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        studentDAO.deleteStudent(idToDelete);
                        break;

                    case 4:
                        List<com.sms.Student> students = studentDAO.getAllStudents();
                        for (Student s : students) {
                            System.out.println(s);
                        }
                        break;

                    case 5:
                        System.out.print("Enter student ID to search: ");
                        int idToSearch = scanner.nextInt();
                        Student searchedStudent = studentDAO.getStudentById(idToSearch);
                        if (searchedStudent != null) {
                            System.out.println(searchedStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
