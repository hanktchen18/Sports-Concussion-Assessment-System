public class RiskAnalyzer {
    private int symptomDifference;
    private int currentSeverityScore;
    private String severityRating;

    public void analyzeRisk(SymptomEntry currentEntry, SymptomEntry previousEntry) {
        int difference = 0;
        for (int i = 0; i < currentEntry.getSymptomScores().size(); i++) {
            difference += Math.abs(currentEntry.getSymptomScores().get(i) - previousEntry.getSymptomScores().get(i));
        }
        symptomDifference = difference;
        currentSeverityScore = currentEntry.calculateSymptomScores();

        if (difference < 3 && currentSeverityScore < 10) {
            severityRating = "No Difference (Green)";
        } else if (difference < 3 && currentSeverityScore >= 10) {
            severityRating = "Unsure (Yellow)";
        } else if (difference >= 3 || currentSeverityScore >= 15) {
            severityRating = "Very Different (Red)";
        } else {
            severityRating = "Unknown";
        }
    }

    public String viewRisk() {
        return severityRating;
    }
}