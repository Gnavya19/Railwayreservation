import java.util.Scanner;
class Train {
    String name;
    int seats;
    Train(String name) {
        this.name = name;
        this.seats = 100; 
    }
}
public class Railwayreservationsystem {
    static Train[] trains = {
        new Train("Train 1"),
        new Train("Train 2"),
        new Train("Train 3"),
        new Train("Train 4"),
        new Train("Train 5")
    };
    static String username = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n--- Railway Reservation System ---");
            if (username == null) {
                System.out.println("1. Register/Login");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    registerOrLogin(scanner);
                } else if (choice == 2) {
                    running = false;
                    System.out.println("Thank you for using the Railway Reservation System!");
                } else {
                    System.out.println("Invalid choice! Please try again.");
                }
            } else {
                System.out.println("Welcome, " + username);
                System.out.println("1. View Trains");
                System.out.println("2. Book a Seat");
                System.out.println("Welcome, " + username);
                System.out.println("1. View Trains");
                System.out.println("2. Book a Seat");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewTrains();
                        break;
                    case 2:
                        bookSeat(scanner);
                        break;
                    case 3:
                        username = null;
                        System.out.println("You have been logged out.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
        scanner.close();
    }
    static void registerOrLogin(Scanner scanner) {
        System.out.print("\nEnter your username: ");
        username = scanner.next();
        System.out.println("Welcome, " + username + "! You are now logged in.");
    }
    static void viewTrains() {
        System.out.println("\nAvailable Trains:");
        for (int i = 0; i < trains.length; i++) {
            System.out.println((i + 1) + ". " + trains[i].name + " | Seats Available: " + trains[i].seats);
        }
    }
    static void bookSeat(Scanner scanner) {
        System.out.println("\nSelect a Train to Book:");
        for (int i = 0; i < trains.length; i++) {
            System.out.println((i + 1) + ". " + trains[i].name + " | Seats Available: " + trains[i].seats);
        }
        System.out.print("Enter train number: ");
        int trainChoice = scanner.nextInt();
        if (trainChoice < 1 || trainChoice > trains.length) {
            System.out.println("Invalid train number! Please try again.");
            return;
        }
        Train selectedTrain = trains[trainChoice - 1];
        if (selectedTrain.seats > 0) {
            selectedTrain.seats--;
            System.out.println("Booking confirmed on " + selectedTrain.name + " for " + username);
        } else {
            System.out.println("No seats available on " + selectedTrain.name);
        }
    }
}
