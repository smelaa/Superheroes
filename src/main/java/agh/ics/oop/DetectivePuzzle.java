package agh.ics.oop;

import java.util.Random;

public class DetectivePuzzle extends AbstractProblem{
    public DetectivePuzzle(int dayOfOccurance) {
        placedOnMap=dayOfOccurance;
        Random generator = new Random();
        solvingTime= generator.nextInt(3) + 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public void startSolving(IHero hero) {
        daysLeftSolve-=hero.getDetectivePuzzleBoost();
    }

    @Override
    public String getImage() {
        return "src/main/resources/pictures/puzzle.png";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/pictures/puzzle_p.png";
    }
    @Override
    public String getName() {
        return "Super Detective";
    }
    @Override
    public String getDescription() {
        return "After Chloe's and Lucifer's retirement, LAPD is helpless." +"\n" +
                "Robert Hunter is too far away to help, still probably he will not be able to solve the crime" +"\n"+
                "All in your hands" +"\n"+
                "Solving time: " + getSolvingTime() + "\n" +
                "Destruction time: " +getDestructionTime() + "\n"+
                "Days left to solve: " + getDaysLeftSolve();

    }


}
