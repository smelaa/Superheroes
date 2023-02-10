package agh.ics.oop;

public interface IHero {
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
}
