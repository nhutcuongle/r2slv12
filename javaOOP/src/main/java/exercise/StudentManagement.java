package exercise;

import java.util.Scanner;

public class StudentManagement {

     static Scanner scanner = new Scanner(System.in);

     static Student[] listStudents = new Student[100];

     static int numberOfStudents = 0;

    public static void main(String[] args) {

        String choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Create a student");
            System.out.println("2. Display all");
            System.out.println("3. Find a student by id");
            System.out.println("4. Update a student by id");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createStudent();
                    break;

                case "2":
                    displayAll();
                    break;

                case "3":
                    findStudentById();
                    break;

                case "4":
                    updateStudentById();
                    break;

                case "5":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (!choice.equals("5"));
    }

    // 1. Create a student
    public static void createStudent() {

        if (numberOfStudents >= 100) {
            System.out.println("Student list is full!");
            return;
        }

        Student student = new Student();

        // Input ID
        do {
            System.out.print("Enter ID: ");
            student.id = scanner.nextLine();

            if (student.id.isEmpty()) {
                System.out.println("ID cannot be empty!");
            } else if (isIdDuplicate(student.id)) {
                System.out.println("ID already exists!");
            }
        } while (student.id.isEmpty() || isIdDuplicate(student.id));

        // Input name
        do {
            System.out.print("Enter name: ");
            student.name = scanner.nextLine();

            if (student.name.isEmpty()) {
                System.out.println("Name cannot be empty!");
            }
        } while (student.name.isEmpty());

        // Input age
        do {
            System.out.print("Enter age: ");
             student.age = Integer.parseInt(scanner.nextLine());

            if (student.age < 18) {
                System.out.println("Age must be >= 18!");
            }
        } while (student.age < 18);

        // Input address
        System.out.print("Enter address: ");
        student.address = scanner.nextLine();

        // Input gender
        do {
            System.out.print("Enter gender (male/female): ");
            student.gender = scanner.nextLine();

            if (!student.gender.equals("male")
                    && !student.gender.equals("female")) {
                System.out.println("Gender must be male or female!");
            }
        } while (!student.gender.equals("male")
                && !student.gender.equals("female"));

        // Input email
        System.out.print("Enter email: ");
        student.email = scanner.nextLine();

        // Add student to array
        listStudents[numberOfStudents++] = student;

        System.out.println("Create student successfully!");
    }

    // Check duplicate ID
    public static boolean isIdDuplicate(String id) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (listStudents[i].id.equalsIgnoreCase(id)) {
                return true;
            }
        }

        return false;
    }

    // 2. Display all students
    public static void displayAll() {

        if (numberOfStudents == 0) {
            System.out.println("Student list is empty!");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (int i = 0; i < numberOfStudents; i++) {

            Student student = listStudents[i];

            System.out.println("-------------------------\n" +
                    "ID: " + student.id + "\n" +
                    "Name: " + student.name + "\n" +
                    "Age: " + student.age + "\n" +
                    "Address: " + student.address + "\n" +
                    "Gender: " + student.gender + "\n" +
                    "Email: " + student.email);
        }
    }

    // 3. Find student by ID
    public static void findStudentById() {

        System.out.print("Enter ID to find: ");
        String id = scanner.nextLine();

        int index = findStudentIndexById(id);

        if (index == -1) {
            System.out.println("Student not found!");
        } else {

            Student student = listStudents[index];

            System.out.println("\n===== STUDENT FOUND =====");
            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Address: " + student.address);
            System.out.println("Gender: " + student.gender);
            System.out.println("Email: " + student.email);
        }
    }

    // Find the position of student in array
    public static int findStudentIndexById(String id) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (listStudents[i].id.equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

    // 4. Update student by ID
    public static void updateStudentById() {

        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine();

        int index = findStudentIndexById(id);

        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        Student student = listStudents[index];

        System.out.println("Student found. Enter new information:");

        // Update name
        do {
            System.out.print("Enter new name: ");
            student.name = scanner.nextLine();

            if (student.name.isEmpty()) {
                System.out.println("Name cannot be empty!");
            }
        } while (student.name.isEmpty());

        // Update age
        do {
            System.out.print("Enter new age: ");
            student.age = scanner.nextInt();
            scanner.nextLine();

            if (student.age < 18) {
                System.out.println("Age must be >= 18!");
            }
        } while (student.age < 18);

        // Update address
        System.out.print("Enter new address: ");
        student.address = scanner.nextLine();

        // Update gender
        do {
            System.out.print("Enter new gender (male/female): ");
            student.gender = scanner.nextLine();

            if (!student.gender.equalsIgnoreCase("male")
                    && !student.gender.equalsIgnoreCase("female")) {
                System.out.println("Gender must be male or female!");
            }
        } while (!student.gender.equalsIgnoreCase("male")
                && !student.gender.equalsIgnoreCase("female"));

        // Update email
        System.out.print("Enter new email: ");
        student.email = scanner.nextLine();

        System.out.println("Update student successfully!");
    }
}