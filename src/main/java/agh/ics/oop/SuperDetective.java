package agh.ics.oop;

public class SuperDetective implements IHero{
    private Vector2d position;
    private int currEnergy=getDailyEnergy();
    private IProblem myOwnProblem=null;

    public SuperDetective(Vector2d position) {
        this.position = position;
    }

    @Override
    public HeroType getHeroType() {
        return HeroType.Detective;
    }

    @Override
    public int getDailyEnergy() {
        return 4;
    }

    @Override
    public int getSupervilainBoost() {
        return - 1;
    }

    @Override
    public int getTechnicalIssueBoost() {
        return 2;
    }

    @Override
    public int getDetectivePuzzleBoost() {
        return 3;
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
        return "src/main/resources/superdetective.jpg";
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
        myOwnProblem.solve();
    }

    @Override
    public String getPortrait() {
        return "src/main/resources/superdetective.jpg";
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
