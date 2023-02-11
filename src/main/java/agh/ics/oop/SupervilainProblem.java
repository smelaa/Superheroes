package agh.ics.oop;

import java.util.Random;

public class SupervilainProblem extends AbstractProblem{
    public SupervilainProblem(int dayOfOccurance) {
        placedOnMap=dayOfOccurance;
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
    }
    @Override
    public String getImage() {
        return "src/main/resources/pictures/supervillain.png";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/pictures/supervillain_p.png";
    }
    @Override
    public String getName() {
        return "Supervilain!!!!";
    }
    @Override
    public String getDescription() {
        return "tu wpisać opis";
    }

}
