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
        return -2;
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
        return "src/main/resources/pictures/fighter.png";
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
        return "src/main/resources/pictures/fighter_p.png";
    }
    @Override
    public String getName() {
        return "Rocky";
    }
    @Override
    public String getDescription() {
        return "Rocky Bamboo achieved everything any fighter dreams about. " +"\n"+
                "Still, his passion, devotion and perseverance rose Rocky to the top " +"\n"+
                "and now not only is he the best fighter in the universe\nbut also fights for the better universe. " +"\n"+
                "\"Who never wanted to become a superhero, throw the rock first\".";
    }
    @Override
    public String getStats(int currDay){
        return "Everyday energy: 6" + "\n"+
                "Energy left today: " + getEnergy() + "\n" +
                "Supervillain solving time: 2 days" + "\n"+
                "Detective puzzle boost: 2 days longer"+ "\n"+
                "Currently solving any problem: "+isSolvingProblemToString();
    }
    @Override
    public void subtractEnergy(IField field){
        currEnergy-= field.energyCost(this);
    }
    @Override
    public boolean isSolvingProblem() {
        return myOwnProblem!=null && !myOwnProblem.isSolved();
    }
    @Override
    public String isSolvingProblemToString() {
        if (isSolvingProblem()) return "YES";
        return "NO";
    }
}
