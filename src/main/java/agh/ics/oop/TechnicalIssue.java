package agh.ics.oop;

import java.util.Random;

public class TechnicalIssue extends AbstractProblem {
    public TechnicalIssue() {
        Random generator = new Random();
        solvingTime = generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getTechnicalIssueBoost();
        currentlySolving=true;
    }
}
