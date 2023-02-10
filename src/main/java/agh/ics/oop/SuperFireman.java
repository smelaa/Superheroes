package agh.ics.oop;

public class SuperFireman implements IHero{
    private Vector2d position;

    public SuperFireman(Vector2d position) {
        this.position = position;
    }

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
        return "src/main/resources/superfireman.jpg";
    }
}
