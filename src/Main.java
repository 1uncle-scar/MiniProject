import java.util.Scanner;

public class Main {

    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Resource Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Admin login
                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    Admin admin = new Admin(adminUsername, adminPassword);
                    if (admin.verifyCredentials()) {
                        System.out.println("Login successful!");
                        handleAdminActions(admin, scanner);
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }

                case 2 -> {
                }

                case 3 -> {
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
            // Staff login (to be implemented)
                    }
    }

    private static void handleAdminActions(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Add Staff");
            System.out.println("4. Remove Staff");
            System.out.println("5. View All Students");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1 -> {
                    // Add student
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student class: ");
                    String studentClass = scanner.nextLine();
                    admin.addStudent(studentName, studentClass);
                }
    
                case 2 -> {
                    // Remove student
                    System.out.print("Enter student ID to remove: ");
                    int studentId = scanner.nextInt();
                    admin.removeStudent(studentId);
                }
    
                case 3 -> {
                    // Add staff
                    System.out.print("Enter staff name: ");
                    String staffName = scanner.nextLine();
                    System.out.print("Enter staff department: ");
                    String staffDepartment = scanner.nextLine();
                    admin.addStaff(staffName, staffDepartment);
                }
    
                case 4 -> {
                    // Remove staff
                    System.out.print("Enter staff ID to remove: ");
                    int staffId = scanner.nextInt();
                    admin.removeStaff(staffId);
                }
    
                case 5 -> // View all students
                    admin.viewAllStudents();
    
                case 6 -> {
                    // Logout
                    System.out.println("Logging out...");
                    return;
                }
    
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
