import java.util.*;

class Application {
    int id;
    String company;
    String role;
    String status;
    String date;

    Application(int id, String company, String role, String status, String date) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.status = status;
        this.date = date;
    }

    void display() {
        System.out.println(id + " | " + company + " | " + role + " | " + status + " | " + date);
    }
}

public class JobTracker {
    static ArrayList<Application> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int count = 1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Job Application Tracker ---");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Update Status");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addApplication();
                    break;
                case 2:
                    viewApplications();
                    break;
                case 3:
                    updateStatus();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addApplication() {
        System.out.print("Company: ");
        String company = sc.nextLine();

        System.out.print("Role: ");
        String role = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        list.add(new Application(count++, company, role, status, date));
        System.out.println("Application Added!");
    }

    static void viewApplications() {
        if (list.isEmpty()) {
            System.out.println("No applications found!");
            return;
        }

        for (Application app : list) {
            app.display();
        }
    }

    static void updateStatus() {
        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Application app : list) {
            if (app.id == id) {
                System.out.print("Enter new status: ");
                app.status = sc.nextLine();
                System.out.println("Status Updated!");
                return;
            }
        }

        System.out.println("Application not found!");
    }
}

