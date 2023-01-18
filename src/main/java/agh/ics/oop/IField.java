package agh.ics.oop;

public interface IField {
    boolean canEnter(int energyLevel);
    boolean canProblemOccur();
    void problemNotHandled();
}
