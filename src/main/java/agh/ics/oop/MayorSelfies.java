package agh.ics.oop;

public class MayorSelfies extends AbstractProblem{
    public MayorSelfies(int dayOfOccurance) {
        placedOnMap=dayOfOccurance;
        solvingTime= 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public int getDestructionTime() {
        return 6;
    }

    @Override
    public void startSolving(IHero hero) {
    }

    @Override
    public String getImage() {
        return "src/main/resources/pictures/mayorselfies.png";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/pictures/mayorselfies_p.png";
    }
    @Override
    public String getName() {
        return "Scandal: Mayor's selfies in newspaper";
    }
    @Override
    public String getDescription() {
        return "Mayor selfies went real!\n Until now only lovely wife could see the beauty of the Mayor " +"\n"+
                "and she will not like to share it with anyone else!" +"\n"+
                "Yet you can get the pictures if you solve the problem." +"\n"+
                "Worth it. ";

    }
    @Override
    public String getStats(int currDay){
        return "Solving time: " + getSolvingTime() + "\n" +
                "Destruction time: " +getDestructionTime() + "\n"+
                "Days left to solve: " + getDaysLeftSolve()+"\n"+
                "Days left till destruction: " + getDaysLeftDestruction(currDay)+"\n"+
                "\nYou won't loose a trust point\nby not solving this problem,\nbut you can earn one if you do.";
    }
    @Override
    public int trustLoaf() {
        return 1;
    }

}
