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
        return "tu wpisać opis";
    }
    @Override
    public int trustLoaf() {
        return 1;
    }

}
