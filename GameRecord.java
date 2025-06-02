import java.util.LinkedList;
import java.util.List;

public class GameRecord {
    private LinkedList<SymptomEntry> gameRecords = new LinkedList<>();

    public LinkedList<SymptomEntry> getGameRecords() {
        return gameRecords;
    }

    public void addEntry(SymptomEntry entry) {
        if (gameRecords.size() >= 5) {
            gameRecords.removeFirst();
        }
        gameRecords.add(entry);
    }

    public void displaySummary() {
        if (gameRecords.isEmpty()) {
            System.out.println("No game records available.");
            return;
        }

        RiskAnalyzer analyzer = new RiskAnalyzer();
        for (int i = 0; i < gameRecords.size(); i++) {
            SymptomEntry currentEntry = gameRecords.get(i);
            System.out.println("Game " + (i + 1) + " - ");
            System.out.println("Total Symptoms: " + currentEntry.getSymptomCount());
            System.out.println("Symptom Scores: " + currentEntry.calculateSymptomScores());

            if (i > 0) {
                SymptomEntry previousEntry = gameRecords.get(i-1);
                analyzer.analyzeRisk(currentEntry, previousEntry);
                System.out.println("Symptom Difference: " + analyzer.viewRisk());
            } else {
                System.out.println("Overall Risk Rating: N/A (first game)");
            }
        }
    }
}