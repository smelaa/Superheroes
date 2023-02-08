package agh.ics.oop;

public class SuperCompuerScientist implements IHero{
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
}
