package agh.ics.oop;

import java.util.Random;

public class TechnicalIssue extends AbstractProblem {
    public TechnicalIssue(int dayOfOccurance) {
        placedOnMap=dayOfOccurance;
        Random generator = new Random();
        solvingTime = generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getTechnicalIssueBoost();
    }
    @Override
    public String getImage() {
        return "src/main/resources/technicalissue.jpg";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/technicalissue.jpg";
    }
    @Override
    public String getName() {
        return "Technical Issue";
    }
    @Override
    public String getDescription() {
        return "tu wpisać opis";
    }
}
