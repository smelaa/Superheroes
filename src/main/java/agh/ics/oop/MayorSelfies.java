package agh.ics.oop;

public class MayorSelfies extends AbstractProblem{
    public MayorSelfies() {
        solvingTime= 3;
        daysLeftSolve=solvingTime;
    }

    @Override
    public int getDestructionTime() {
        return 6;
    }
    @Override
    public void newDayAlert(Engine engine) {
        if(getDestructionTime()<=timeOnMap){
            engine.getMap().removeProblem(position);
        }
        else if (daysLeftSolve<=0){
            engine.getMap().removeProblem(position);
            engine.addTrustPoints(1);
        }
        if (currentlySolving){
            daysLeftSolve-=1;
        }
        timeOnMap+=1;
    }

    @Override
    public void startSolving(IHero hero) {
        currentlySolving=true;
    }



}
