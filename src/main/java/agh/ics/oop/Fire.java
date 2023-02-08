package agh.ics.oop;

import java.util.Random;

public class Fire extends AbstractProblem{
    public Fire() {
        Random generator = new Random();
        solvingTime = generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }
    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getFireBoost();
        currentlySolving=true;
    }
}
