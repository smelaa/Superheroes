package agh.ics.oop;


public abstract class AbstractProblem implements IProblem {
    protected int placedOnMap;
    protected int solvingTime;
    protected int daysLeftSolve;
    protected Vector2d position=null;

    public int getSolvingTime() {
        return solvingTime;
    }
    public int getDestructionTime() {
        return getSolvingTime() * 3;
    }

    public void placeOnMap(Vector2d position) {
        this.position=position;
    }

    abstract public void startSolving(IHero hero);

    public void stopSolving(){
        daysLeftSolve=solvingTime;
    }
    public abstract String getImage();
    abstract public String getName();
    abstract public String getPortrait();
    abstract public String getDescription();
    public boolean isSolved(){
        return daysLeftSolve<=0;
    }
    public void solve(){
        daysLeftSolve-=1;
    }
    public int trustLoaf(){return 0;}
    public int getDaysLeftSolve(){
        return daysLeftSolve;
    }

    @Override
    public boolean shouldBeDestructed(int currDay) {
        return getDestructionTime()<currDay-placedOnMap;
    }
}
