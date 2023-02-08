package agh.ics.oop;

import java.util.Random;

public class DetectivePuzzle extends AbstractProblem{
    public DetectivePuzzle() {
        Random generator = new Random();
        solvingTime= generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getDetectivePuzzleBoost();
        currentlySolving=true;
    }

}
