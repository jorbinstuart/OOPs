import java.util.ArrayList;
import java.util.Scanner;
class Person {
    protected int id;
    protected String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}
class Employee extends Person {
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        super(id, name);
        this.department = department;
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id +", Name: " + name +", Department: " + department +", Salary: " + salary);
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added successfully!");
    }
    public void removeEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                employees.remove(e);
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
    public void searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.display();
                return;
            }
        }
        System.out.println("Employee not found!");
    }
    public void updateEmployee(int id, String dept, double salary) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setDepartment(dept);
                e.setSalary(salary);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }
        for (Employee e : employees) {
            e.display();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    ems.addEmployee(new Employee(id, name, dept, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    ems.removeEmployee(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    ems.searchEmployee(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("New Salary: ");
                    double newSalary = sc.nextDouble();

                    ems.updateEmployee(uid, newDept, newSalary);
                    break;

                case 5:
                    ems.displayAllEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

