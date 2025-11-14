package lab08.app;

import lab08.classes.Mathematics;
import lab08.classes.Physics;
import lab08.classes.Subject;
import lab08.classes.History;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Mathematics math = new Mathematics("Algebra", 32, 6, 1);
        System.out.println("Создан предмет Math: " + math);

        History history = new History();
        history.setTitle("WorldHistory");
        history.setHours(24);
        history.setDifficulty(4);
        history.setPeriodFocus("Medieval");
        System.out.println("Создан предмет History: " + history);

        Physics physics = new Physics("Quantum Mechanics", 40, 8, true, 2);
        System.out.println("Создан предмет Physics: " + physics);

        Physics physicsCopy = new Physics(physics);
        physicsCopy.setLab(false);
        physicsCopy.setExperiments(0);
        System.out.println("Создана копия Physics: " + physicsCopy);
        System.out.println("Оригинал Physics после копирования: " + physics);
        System.out.println("----------------------------------------\n");

        math.addHours(4);
        history.addHours(3);
        physics.addHours(5);
        physicsCopy.addHours(5);
        System.out.println("Добавили часы всем предметам:");
        System.out.println("Math: " + math.getHours() + "h");
        System.out.println("History: " + history.getHours() + "h");
        System.out.println("Physics: " + physics.getHours() + "h");
        System.out.println("Physics (Copy): " + physicsCopy.getHours() + "h");

        System.out.println("\nMath.solveProblems(23):");
        System.out.println("Math до: " + math.getTopicsMastered() + " тем, " + math.getProgress() + " прогресса");
        math.solveProblems(23);
        System.out.println("Math после: " + math.getTopicsMastered() + " тем, " + math.getProgress() + " прогресса");

        System.out.println("\nHistory.readSource() дважды:");
        System.out.println("History до: " + history.getSourcesRead() + " источников, " + history.getProgress() + " прогресса");
        history.readSource();
        history.readSource();
        System.out.println("History после: " + history.getSourcesRead() + " источников, " + history.getProgress() + " прогресса");

        System.out.println("\nPhysics.runExperiment(\"FreeFall\") для оригинала:");
        System.out.println("Physics до: " + physics.getExperiments() + " экспериментов, " + physics.getProgress() + " прогресса");
        physics.runExperiment("FreeFall");
        System.out.println("Physics после: " + physics.getExperiments() + " экспериментов, " + physics.getProgress() + " прогресса");

        System.out.println("\nPhysics (Copy).runExperiment(\"Electricity\") для копии:");
        System.out.println("Physics (Copy) до: " + physicsCopy.getExperiments() + " экспериментов, " + physicsCopy.getProgress() + " прогресса");
        physicsCopy.runExperiment("Electricity");
        System.out.println("Physics (Copy) после: " + physicsCopy.getExperiments() + " экспериментов, " + physicsCopy.getProgress() + " прогресса");
        System.out.println("----------------------------------------\n");


        System.out.println("Сессии начинаются:\n");
        Subject[] plan = { math, history, physics, physicsCopy };

        System.out.println("ПЕРВАЯ ПАРА ЗАНЯТИЙ (45 минут):\n");
        for (Subject s : plan) {
            int gained = s.study(45);
            System.out.printf("%s: Набрано очков: %d, Текущий прогресс: %d\n", s.getTitle(), gained, s.getProgress());
        }

        System.out.println("\nВТОРАЯ ПАРА ЗАНЯТИЙ (75 минут):\n");
        for (Subject s : plan) {
            int gained = s.study(75);
            System.out.printf("%s: Набрано очков: %d, Текущий прогресс: %d\n", s.getTitle(), gained, s.getProgress());
        }
        System.out.println("----------------------------------------\n");

        System.out.println("Меняем период History на Renaissance:");
        System.out.println("History до: " + history);
        history.setPeriodFocus("Renaissance");
        int historyGain = history.study(60);
        System.out.println("History после study(60) с новым фокусом: " + history);
        System.out.printf("History: Набрано очков: %d, Текущий прогресс: %d\n", historyGain, history.getProgress());

        System.out.println("\nРаботаем с копией Physics:");
        System.out.println("Physics (Copy) до: " + physicsCopy);
        physicsCopy.setLab(true); // Включаем лабы
        int physicsCopyGain1 = physicsCopy.study(40);
        System.out.println("Physics (Copy) после study(40) с включенными лабами: " + physicsCopy);
        System.out.printf("Physics (Copy): Набрано очков: %d, Текущий прогресс: %d\n", physicsCopyGain1, physicsCopy.getProgress());

        physicsCopy.setLab(false);
        int physicsCopyGain2 = physicsCopy.study(40);
        System.out.println("Physics (Copy) после study(40) с выключенными лабами: " + physicsCopy);
        System.out.printf("Physics (Copy): Набрано очков: %d, Текущий прогресс: %d\n", physicsCopyGain2, physicsCopy.getProgress());
        System.out.println("----------------------------------------\n");


        System.out.println("ФИНАЛЬНЫЙ ОТЧЁТ:\n");
        int maxProgress = -1;
        String maxProgressSubject = "";

        for (Subject s : plan) {
            System.out.println(s);
            if (s.getProgress() > maxProgress) {
                maxProgress = s.getProgress();
                maxProgressSubject = s.getTitle();
            }
        }
        System.out.println("\n----------------------------------------");
        System.out.printf("Предмет с максимальным прогрессом: %s с %d очками прогресса. " +
                "Молодцом!\n", maxProgressSubject, maxProgress);
    }
}