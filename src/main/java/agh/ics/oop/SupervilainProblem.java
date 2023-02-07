package agh.ics.oop;

import java.util.Random;

public class SupervilainProblem implements IProblem{
    private static int time;

    @Override
    public int getSolvingTime() {
        Random generator = new Random();
        time = generator.nextInt(3) + 5;
        return time;
    }

    @Override
    public int getDestructionTime() {
        return getSolvingTime() * 2;
    }

    @Override
    public double getOccuranceChance() {
        return 0.15;
    }

    public static int getSolveTime(){
        return time;
    }
}
