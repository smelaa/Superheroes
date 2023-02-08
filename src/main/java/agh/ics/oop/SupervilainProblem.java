package agh.ics.oop;

import java.util.Random;

public class SupervilainProblem extends AbstractProblem{
    public SupervilainProblem() {
        Random generator = new Random();
        solvingTime = generator.nextInt(3) + 5;
        daysLeftSolve=solvingTime;
    }
    @Override
    public int getDestructionTime() {
        return getSolvingTime() * 2;
    }
    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getSupervilainBoost();
        currentlySolving=true;
    }

}
