package agh.ics.oop;

public class RegularField implements IField{
    @Override
    public boolean canEnter(int energyLevel) {
        return false;
    }

    @Override
    public boolean canProblemOccur() {
        return false;
    }

    @Override
    public void problemNotHandled() {

    }
}
