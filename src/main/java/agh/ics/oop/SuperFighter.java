package agh.ics.oop;

public class SuperFighter implements IHero{
    private Vector2d position;
    private int currEnergy=getDailyEnergy();
    private IProblem myOwnProblem=null;

    public SuperFighter(Vector2d position) {
        this.position = position;
    }

    @Override
    public HeroType getHeroType() {
        return HeroType.Fighter;
    }

    @Override
    public int getDailyEnergy() {
        return 6;
    }

    @Override
    public int getSupervilainBoost() {
        return 2;
    }

    @Override
    public int getTechnicalIssueBoost() {
        return 0;
    }

    @Override
    public int getDetectivePuzzleBoost() {
        return 2;
    }

    @Override
    public int getFireBoost() {
        return 0;
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
        return "src/main/resources/superfighter.jpg";
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
        return "src/main/resources/superfighter.jpg";
    }
    @Override
    public String getName() {
        return "Super Fighter";
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
