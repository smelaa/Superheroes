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
        return "tu wpisać opis";
    }


}
