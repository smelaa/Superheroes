package agh.ics.oop;

public class SuperCompuerScientist implements IHero{
    private Vector2d position;
    private int currEnergy=getDailyEnergy();
    private IProblem myOwnProblem=null;

    public SuperCompuerScientist(Vector2d position) {
        this.position = position;
    }

    @Override
    public HeroType getHeroType() {
        return HeroType.ComputerScientist;
    }

    @Override
    public int getDailyEnergy() {
        return 3;
    }

    @Override
    public int getSupervilainBoost() {
        return  2;
    }

    @Override
    public int getTechnicalIssueBoost() {
        return 1;
    }

    @Override
    public int getDetectivePuzzleBoost() {
        return - 1;
    }

    @Override
    public int getFireBoost() {
        return 1;
    }

    @Override
    public boolean canPassRiver() {
        return false;
    }

    @Override
    public void changePosition(Vector2d newPos) {
        position=newPos;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }
    @Override
    public String getImage() {
        return "src/main/resources/pictures/scientist.png";
    }

    @Override
    public int getEnergy() {
        return currEnergy;
    }

    @Override
    public int renewEnergy() {
        return currEnergy=getDailyEnergy();
    }

    @Override
    public void assignProblem(IProblem problem) {
        if (myOwnProblem!=null){myOwnProblem.stopSolving();}
        if (problem!=null){problem.startSolving(this);}
        myOwnProblem=problem;
    }

    @Override
    public void fightProblem() {
        if (myOwnProblem!=null) {
            myOwnProblem.solve();
        }
    }

    @Override
    public String getPortrait() {
        return "src/main/resources/pictures/scientist_p.png";
    }
    @Override
    public String getName() {
        return "Bug Buster";
    }
    @Override
    public String getDescription() {
        return "tu wpisać opis";
    }

    @Override
    public void subtractEnergy(IField field){
        currEnergy-= field.energyCost(this);
    }

}
