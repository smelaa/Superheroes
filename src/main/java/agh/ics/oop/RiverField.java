package agh.ics.oop;

public class RiverField implements IField{
    @Override
    public boolean canEnter(int energyLevel, IHero hero) {
        return switch(hero.getHeroType()){
            case Fireman -> true;
            default -> false;
        };
    }

    @Override
    public boolean canProblemOccur() {
        return false;
    }

    @Override
    public void problemNotHandled(Engine gameEngine) {
    }

    @Override
    public int energyCost(IHero hero) {
        return switch(hero.getHeroType()){
            case Fireman -> 1;
            default -> Integer.MAX_VALUE;
        };
    }
    @Override
    public String getColor(){return "-fx-background-color: #48D1F0";}
}
