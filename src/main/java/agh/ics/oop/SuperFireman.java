package agh.ics.oop;

public class SuperFireman implements IHero{
    @Override
    public HeroType getHeroType() {
        return HeroType.Fireman;
    }

    @Override
    public int getDailyEnergy() {
        return 4;
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
        return - 2;
    }

    @Override
    public boolean canPassRiver() {
        return true;
    }
}
