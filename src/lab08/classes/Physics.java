package lab08.classes;

import java.lang.Math;

public class Physics extends Subject {
    private boolean lab;
    private int experiments;

    // region Contstuctors
    public Physics() {
        super();
        this.lab = false;
        this.experiments = 0;
    }

    public Physics(String title, int hours, int difficulty, boolean lab, int experiments) {
        super(title, hours, difficulty);
        this.lab = lab;
        setExperiments(experiments);
    }

    public Physics(Physics other) {
        super(other);
        this.lab = other.lab;
        this.experiments = other.experiments;
    }
    //endregion

    public boolean hasLab() {
        return lab;
    }

    public void setLab(boolean lab) {
        this.lab = lab;
    }

    public int getExperiments() {
        return experiments;
    }

    public void setExperiments(int experiments) {
        this.experiments = Math.max(0, experiments);
    }

    @Override
    public int study(int minutes) {
        if (minutes <= 0) {
            return 0;
        }
        int base = (minutes / 6) * effectiveness();
        int labBonus = lab ? (minutes / 20) : 0;
        int expBonus = experiments / 2;
        int gain = base + labBonus + expBonus;
        setProgress(getProgress() + gain);
        return gain;
    }

    public void runExperiment(String title) {
        this.experiments++;
        setProgress(getProgress() + 2);
    }

    @Override
    public String toString() {
        return String.format("%s, Has Lab: %b, Experiments: %d", super.toString(), lab, experiments);
    }
}