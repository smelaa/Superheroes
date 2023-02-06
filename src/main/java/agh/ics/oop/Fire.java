package agh.ics.oop;

import java.util.Random;

public class Fire implements IProblem{

    private static int time;

    @Override
    public int getSolvingTime() {
        Random generator = new Random();
        time = generator.nextInt(3) + 3;
        return time;
    }

    @Override
    public int getDestructionTime() {
        return getSolvingTime() * 3;
    }

    @Override
    public double getOccuranceChance() {
        return 0.85;
    }

    public static int getSolveTime(){
        return time;
    }
}
