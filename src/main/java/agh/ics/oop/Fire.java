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
        return "src/main/resources/pictures/fire.png";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/pictures/fire_p.png";
    }
    @Override
    public String getName() {
        return "Fire";
    }
    @Override
    public String getDescription() {
        return "Now I see fire Inside the mountain"+"\n" +
                "And I see fire Burning the trees"+"\n" +
                "And I see fire Hollowing soul"+"\n" +
                "And I see fire Blood in the breeze"+"\n" +
                "Solving time: " + getSolvingTime() + "\n" +
                "Destruction time: " +getDestructionTime() + "\n";
    }
}
