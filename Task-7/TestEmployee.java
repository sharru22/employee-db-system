import java.util.Scanner;

public class TestEmployee {
    public static void main(String[] args) {
        EmployeeOperations empOps = new EmployeeOperations();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Database Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    empOps.addEmployee(name, email, salary);
                    break;

                case 2:
                    empOps.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to update salary: ");
                    int idToUpdate = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    sc.nextLine();
                    empOps.updateEmployeeSalary(idToUpdate, newSalary);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    empOps.deleteEmployee(idToDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
