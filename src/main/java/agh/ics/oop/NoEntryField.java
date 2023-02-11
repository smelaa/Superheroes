package agh.ics.oop;

public class NoEntryField implements IField{
    @Override
    public boolean canEnter(int energyLevel, IHero hero) {
        return false;
    }

    @Override
    public boolean canProblemOccur() {
        return false;
    }

    @Override
    public void problemNotHandled(Engine gameEngine) {
        gameEngine.removeTrustPoints(0);

    }

    @Override
    public int energyCost(IHero hero) {
        return Integer.MAX_VALUE;
    }
    @Override
    public String getColor(){return "-fx-background-color: #00420A";}
}
