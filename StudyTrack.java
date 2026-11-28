import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class StudyTrack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<StudySession> sessions = new ArrayList<>();
        try {
    BufferedReader reader = new BufferedReader(
        new FileReader("sessions.csv")
    );

    String line;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        if (parts.length == 3) {
            String subject = parts[0];
            LocalDate date = LocalDate.parse(parts[1]);
            int duration = Integer.parseInt(parts[2]);

            StudySession session = new StudySession(
                subject, date, duration
            );

            sessions.add(session);
        }
    }

    reader.close();

} catch (java.io.FileNotFoundException e) {
    System.out.println("No previous sessions found.");

} catch (IOException e) {
    System.out.println("Error loading sessions.");
}

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
    scanner.nextLine();

    System.out.print("Enter subject: ");
    String subject = scanner.nextLine();

    System.out.print("Enter date (YYYY-MM-DD): ");
    LocalDate date = LocalDate.parse(scanner.nextLine());

    System.out.print("Enter duration (minutes): ");
    int duration = scanner.nextInt();

    StudySession session = new StudySession(subject, date, duration);

    try {
        PrintWriter writer = new PrintWriter(
            new FileWriter("sessions.csv", true)
        );

        writer.println(
            session.getSubject() + "," +
            session.getDate() + "," +
            session.getDuration()
        );

        writer.close();
        sessions.add(session);

        System.out.println("Study session saved!");

    } catch (IOException e) {
        System.out.println("Error saving study session.");
    }

    break;

                case 2:
                    if (sessions.isEmpty()) {
                        System.out.println("No study sessions found.");
                    } else {
                        System.out.println("\nStudy Sessions:");

                        for (StudySession s : sessions) {
                            System.out.println(
                                s.getSubject() + " | " +
                                s.getDate() + " | " +
                                s.getDuration() + " minutes"
                            );
                        }
                    }
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
