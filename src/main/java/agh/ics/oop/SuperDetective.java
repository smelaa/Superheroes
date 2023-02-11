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
        return "src/main/resources/pictures/detective.png";
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
        return "src/main/resources/pictures/detective_p.png";
    }
    @Override
    public String getName() {
        return "Sherlock Horns";
    }
    @Override
    public String getDescription() {
        return "No need to introduce the greatest detective of all time. He is behind resolving the most difficult cases in the world, " + "\n"+
                "like \"where the hedgehog stomps at night\". When Ram Rum asked him to do the mayor a favour, " + "\n"+
                "he did not hesitate to help the citizens." + "\n"+
                "\n" +
                "Everyday energy: 4" + "\n"+
                "Energy left today: " + getEnergy() + "\n" +
                "Supervillain solving time: 1 day faster" + "\n" +
                "Detective puzzle boost: 3 days faster" + "\n"+
                "Technical issue: 2 days longer";
    }
    @Override
    public void subtractEnergy(IField field){
        currEnergy-= field.energyCost(this);
    }
}
