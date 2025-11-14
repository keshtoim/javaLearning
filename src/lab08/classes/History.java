package lab08.classes;

import java.lang.Math;

public class History extends Subject {
    private String periodFocus;
    private int sourcesRead;

    // region Contstuctors
    public History() {
        super();
        this.periodFocus = "General";
        this.sourcesRead = 0;
    }

    public History(String title, int hours, int difficulty, String periodFocus, int sourcesRead) {
        super(title, hours, difficulty);
        setPeriodFocus(periodFocus);
        setSourcesRead(sourcesRead);
    }

    public History(History other) {
        super(other);
        this.periodFocus = other.periodFocus;
        this.sourcesRead = other.sourcesRead;
    }
    //endregion

    public String getPeriodFocus() {
        return periodFocus;
    }

    public void setPeriodFocus(String periodFocus) {
        this.periodFocus = (periodFocus == null || periodFocus.trim().isEmpty()) ? "General" : periodFocus;
    }

    public int getSourcesRead() {
        return sourcesRead;
    }

    public void setSourcesRead(int sourcesRead) {
        this.sourcesRead = Math.max(0, sourcesRead);
    }

    @Override
    public int study(int minutes) {
        if (minutes <= 0) {
            return 0;
        }
        int base = (minutes / 7) * effectiveness();
        int longSessionBonus = minutes >= 60 ? 5 : 0;
        int sourceBonus = sourcesRead / 3;
        int gain = base + longSessionBonus + sourceBonus;
        setProgress(getProgress() + gain);
        return gain;
    }

    public void readSource() {
        this.sourcesRead++;
        setProgress(getProgress() + 1);
    }

    @Override
    public String toString() {
        return String.format("%s, Period Focus: %s, Sources Read: %d", super.toString(), periodFocus, sourcesRead);
    }
}
