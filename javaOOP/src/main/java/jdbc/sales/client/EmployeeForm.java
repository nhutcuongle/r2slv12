package jdbc.sales.client;

import jdbc.sales.entities.Employee;

import java.util.Scanner;

public class EmployeeForm {
    private final Scanner sc;

    public EmployeeForm(Scanner sc) {
        this.sc = sc;
    }

    public int getId() {
        int id;

        System.out.print("Enter id: ");
        id = Integer.parseInt(sc.nextLine());

        return id;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();

        System.out.print("Enter last name: ");
        employee.setLastName(sc.nextLine());

        System.out.print("Enter first name: ");
        employee.setFirstName(sc.nextLine());

        System.out.print("Enter birth date (YYYY-MM-DD): ");
        employee.setBirthdate(sc.nextLine());

        System.out.print("Enter supervisor id: ");
        employee.setSupervisor(Integer.parseInt(sc.nextLine()));

        return employee;
    }
}
