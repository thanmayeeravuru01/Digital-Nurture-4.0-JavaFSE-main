package exercise4;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + 
               ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added: " + employee);
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null;
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add employees
        ems.addEmployee(new Employee(1, "Alice", "Manager", 60000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 45000));

        // Traverse
        System.out.println("\nAll Employees:");
        ems.traverseEmployees();

        // Search
        System.out.println("\nSearch Result: " + ems.searchEmployee(2));

        // Delete
        ems.deleteEmployee(1);

        // Traverse after deletion
        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
