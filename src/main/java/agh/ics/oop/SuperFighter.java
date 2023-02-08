package agh.ics.oop;

public class SuperFighter implements IHero{
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
}
