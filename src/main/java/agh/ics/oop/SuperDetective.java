package agh.ics.oop;

public class SuperDetective implements IHero{
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
}
