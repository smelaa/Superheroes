package agh.ics.oop;

public class SuperFighter implements IHero{
    private Vector2d position;

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
        return "src/main/resources/superfighter.jpg";
    }
}
