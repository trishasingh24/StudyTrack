import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class StudyTrack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n===== STUDYTRACK =====");
            System.out.println("1. Add Study Session");
            System.out.println("2. View Study Sessions");
            System.out.println("3. View Study Statistics");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add session coming soon!");
                    break;

                case 2:
                    System.out.println("View sessions coming soon!");
                    break;

                case 3:
                    System.out.println("Statistics coming soon!");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
