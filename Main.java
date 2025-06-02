import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Athlete athlete = new Athlete("0001", "Hank");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter your athlete ID and name to start!");
        System.out.print("Athlete ID: ");
        String athleteId = scanner.nextLine();
        System.out.print("Athlete Name: ");
        String athleteName = scanner.nextLine();
        athlete = new Athlete(athleteId, athleteName);
        System.out.println("Welcome, " + athleteName + "! Your ID is " + athleteId + ".");

        int choice;
        while (true) {
            System.out.println("==============================================================================================");
            System.out.println("Welcome to the Athlete Symptom Tracker! Please submit a new symptom entry after each game.");
            System.out.println("1. Submit Symptoms");
            System.out.println("2. Display Symtpoms Summary");
            System.out.println("3. Am I at risk?");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Entering a new Symptom Entry...");
                    athlete.submitSymptom();
                    break;
                case 2:
                    System.out.println("Displaying Symptoms Summary...");
                    athlete.viewSymptomSummary();
                    break;
                case 3:
                    System.out.println("Analyzing Risk Condition...");
                    athlete.viewRisk();
                    break;              
                case 4:
                    System.out.println("Exiting the program.");
                    return;
            }
        }
    }
}
