package agh.ics.oop;

public class RegularField implements IField{
    @Override
    public boolean canEnter(int energyLevel, IHero hero) {
        return true;
    }

    @Override
    public boolean canProblemOccur() {
        return true;
    }

    @Override
    public void problemNotHandled(Engine gameEngine) {
        gameEngine.removeTrustPoints(1);
    }
}
