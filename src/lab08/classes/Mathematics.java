package lab08.classes;

import java.lang.Math;

public class Mathematics extends Subject {
    private int topicsMastered;

    // region Contstuctors
    public Mathematics() {
        super();
        this.topicsMastered = 0;
    }

    public Mathematics(String title, int hours, int difficulty, int topicsMastered) {
        super(title, hours, difficulty);
        setTopicsMastered(topicsMastered);
    }

    public Mathematics(Mathematics other) {
        super(other);
        this.topicsMastered = other.topicsMastered;
    }
    //endregion

    public int getTopicsMastered() {
        return topicsMastered;
    }

    public void setTopicsMastered(int topicsMastered) {
        this.topicsMastered = Math.max(0, topicsMastered);
    }

    @Override
    public int study(int minutes) {
        if (minutes <= 0) {
            return 0;
        }
        int base = (minutes / 5) * effectiveness();
        int bonus = topicsMastered;
        int gain = base + bonus;
        setProgress(getProgress() + gain);
        return gain;
    }

    public void solveProblems(int problems) {
        if (problems > 0) {
            this.topicsMastered += problems / 10;
            setProgress(getProgress() + (problems / 5));
        }
    }

    @Override
    public String toString() {
        return String.format("%s, Topics Mastered: %d", super.toString(), topicsMastered);
    }
}
