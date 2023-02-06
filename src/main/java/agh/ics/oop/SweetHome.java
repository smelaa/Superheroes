package agh.ics.oop;

public class SweetHome implements IField{
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
        gameEngine.gameOver();
    }

    @Override
    public int energyCost(IHero hero) {
        return 1;
    }

}
