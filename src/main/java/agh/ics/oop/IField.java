package agh.ics.oop;

public interface IField {
    boolean canEnter(int energyLevel, IHero hero);
    boolean canProblemOccur();
    void problemNotHandled(Engine gameEngine);

    int energyCost(IHero hero);

    String getColor();
}
