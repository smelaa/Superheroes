package agh.ics.oop;

public class SuperFireman implements IHero{
    @Override
    public int getDailyEnergy() {
        return 0;
    }

    @Override
    public int getSupervilainBoost() {
        return 0;
    }

    @Override
    public int getTechnicalIssueBoost() {
        return 0;
    }

    @Override
    public int getDetectivePuzzleBoost() {
        return 0;
    }

    @Override
    public int getFireBoost() {
        return 0;
    }

    @Override
    public boolean canPassRiver() {
        return false;
    }
}
