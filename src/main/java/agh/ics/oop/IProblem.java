package agh.ics.oop;

public interface IProblem {
    int getSolvingTime();
    int getDestructionTime();
    void newDayAlert(Engine engine);
    void placeOnMap(Vector2d position);
    void startSolving(IHero hero);
    void stopSolving();
}
