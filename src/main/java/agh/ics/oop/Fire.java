package agh.ics.oop;

import java.util.Random;

public class Fire extends AbstractProblem{
    public Fire(int dayOfOccurance) {
        placedOnMap=dayOfOccurance;
        Random generator = new Random();
        solvingTime = generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }
    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getFireBoost();
    }
    @Override
    public String getImage() {
        return "src/main/resources/fire.jpg";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/fire.jpg";
    }
    @Override
    public String getName() {
        return "Fire";
    }
    @Override
    public String getDescription() {
        return "tu wpisać opis";
    }
}
