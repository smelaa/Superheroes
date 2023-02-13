package agh.ics.oop;

public interface IHero extends IMapElement{
    HeroType getHeroType();
    int getDailyEnergy();
    int getSupervilainBoost();
    int getTechnicalIssueBoost();
    int getDetectivePuzzleBoost();
    int getFireBoost();
    boolean canPassRiver();
    void changePosition(Vector2d newPos);

    Vector2d getPosition();

    String getImage();

    int getEnergy();
    int renewEnergy();

    void assignProblem(IProblem problem);
    void fightProblem();

    void subtractEnergy(IField field);
    boolean isSolvingProblem();
    String isSolvingProblemToString();
}
