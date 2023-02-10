package agh.ics.oop;

import java.util.Random;

public abstract class AbstractProblem implements IProblem {
    protected int solvingTime;
    protected int daysLeftSolve;
    protected int timeOnMap=0;
    protected Vector2d position=null;
    protected boolean currentlySolving=false;

    public int getSolvingTime() {
        return solvingTime;
    }
    public int getDestructionTime() {
        return getSolvingTime() * 3;
    }

    public void newDayAlert(Engine engine) {
        if(getDestructionTime()<=timeOnMap){
            engine.problemNotHandled(position);
            engine.getMap().removeProblem(position);
        }
        else if (daysLeftSolve<=0){
            engine.getMap().removeProblem(position);
        }
        if (currentlySolving){
            daysLeftSolve-=1;
        }
        timeOnMap+=1;
    }

    public void placeOnMap(Vector2d position) {
        this.position=position;
    }

    abstract public void startSolving(IHero hero);

    public void stopSolving(){
        currentlySolving=false;
        daysLeftSolve=solvingTime;
    }
    public abstract String getImage();
}
