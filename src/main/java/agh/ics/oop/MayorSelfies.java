package agh.ics.oop;

public class MayorSelfies implements IProblem{
    @Override
    public int getSolvingTime() {
        return 3;
    }

    @Override
    public int getDestructionTime() {
        return 6;
    }

    @Override
    public double getOccuranceChance() {
        return 100;
    }
}
