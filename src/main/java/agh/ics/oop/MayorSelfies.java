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
        return "src/main/resources/mayorselfies.jpg";
    }
    @Override
    public String getPortrait() {
        return "src/main/resources/mayorselfies.jpg";
    }
    @Override
    public String getName() {
        return "Mayor selfies";
    }
    @Override
    public String getDescription() {
        return "tu wpisać opis";
    }
    @Override
    public int trustLoaf() {
        return 1;
    }

}
