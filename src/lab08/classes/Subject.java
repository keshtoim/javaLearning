package lab08.classes;

import java.lang.Math;

public abstract class Subject {
    private String title;
    private int hours;
    private int progress;
    private int difficulty;

    // region Contstuctors
    public Subject() {
        this("NoTitle", 0, 5);
    }

    public Subject(String title, int hours, int difficulty) {
        setTitle(title);
        setHours(hours);
        setDifficulty(difficulty);
        this.progress = 0;
    }

    public Subject(Subject other) {
        this.title = other.title;
        this.hours = other.hours;
        this.progress = other.progress;
        this.difficulty = other.difficulty;
    }
    //endregion

    //region get and set
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = (title == null || title.trim().isEmpty()) ? "NoTitle" : title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = Math.max(0, hours);
    }

    public int getProgress() {
        return progress;
    }

    protected void setProgress(int progress) {
        this.progress = Math.max(0, progress);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = Math.max(1, Math.min(10, difficulty));
    }

    //endregion

    public void addHours(int h) {
        this.hours += Math.max(0, h);
    }

    public int effectiveness() {
        return Math.max(1, 11 - difficulty);
    }

    public abstract int study(int minutes);

    @Override
    public String toString() {
        return String.format("Type: %s, Title: %s, Hours: %d, Difficulty: %d, Progress: %d",
                getClass().getSimpleName(), title, hours, difficulty, progress);
    }
}
