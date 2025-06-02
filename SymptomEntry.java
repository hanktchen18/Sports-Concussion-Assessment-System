import java.util.List;

public class SymptomEntry {
    private List<Integer> symptomScores;

    public SymptomEntry(List<Integer> symptomScores) {
        this.symptomScores = symptomScores;
    }

    public int calculateSymptomScores() {
        int totalScore = 0;
        for (int score : symptomScores) {
            totalScore += score;
        }
        return totalScore;
    }

    public int getSymptomCount() {
        int count = 0;
        for (int score : symptomScores) {
            if (score > 0) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getSymptomScores() {
        return symptomScores;
    }
}