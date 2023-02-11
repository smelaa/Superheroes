package agh.ics.oop;

public class HardToPassField implements IField{
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

    @Override
    public int energyCost(IHero hero) {
        return 2;
    }

    @Override
    public String getColor(){return "-fx-background-color: #24960B";}
}
