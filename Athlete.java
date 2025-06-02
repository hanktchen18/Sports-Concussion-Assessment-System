import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Athlete {
    private String id;
    private String name;
    private GameRecord gameRecords;

    public Athlete(String id, String name) {
        this.id = id;
        this.name = name;
        this.gameRecords = new GameRecord();
    }

    public void submitSymptom() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> symptomScores = new ArrayList<>();
        String[] symptomNames = {
            "Headache", "Pressure in head", "Neck pain", "Nausea or vomitting", "Dizziness",
            "Blurred vision", "Balance problems", "Sensitivity to light", "Sensitivity to noise",
            "Feeling slowed down", "Feeling like \"in a fog\"", "\"Don't feel right\"", "Difficulty concentrating",
            "Difficulty remembering", "Fatigue or low energy", "Confusion", "Drowsiness", "Trouble falling asleep",
            "More emotional", "Irritability", "Sadness", "Nervous or anxious"
        };
        
        System.out.println("Please rate the following symptoms:");
        for (String symptom : symptomNames) {
            int score;
            do {
                System.out.println("Enter score for " + symptom + " (none: 0, mild: 1-2, moderate: 3-4, severe: 5-6)");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 0 and 6.");
                    scanner.next();
                }
                score = scanner.nextInt();
                if (score < 0 || score > 6) {
                    System.out.println("Invalid score. Please enter a number between 0 and 6.");
                }
            } while (score < 0 || score > 6);
            symptomScores.add(score);
        }

        SymptomEntry entry = new SymptomEntry(symptomScores);
        System.out.println(entry);
        gameRecords.addEntry(entry);
        System.out.println("Symptom entry recorded successfully.");
    }

    public void viewSymptomSummary() {
        gameRecords.displaySummary();
    }

    public void viewRisk() {
        if (gameRecords.getGameRecords().size() < 2) {
            System.out.println("Not enough game records to analyze risk. Please submit at least 2 symptom entries.");
            return;
        }

        RiskAnalyzer analyzer = new RiskAnalyzer();
        SymptomEntry currentEntry = gameRecords.getGameRecords().getLast();
        SymptomEntry previousEntry = gameRecords.getGameRecords().get(gameRecords.getGameRecords().size() - 2);
        
        analyzer.analyzeRisk(currentEntry, previousEntry);
        System.out.println("Risk Analysis Result: " + analyzer.viewRisk());
    }
}