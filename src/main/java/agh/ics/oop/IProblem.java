package agh.ics.oop;

public interface IProblem extends IMapElement{
    int getSolvingTime();
    int getDestructionTime();
    void placeOnMap(Vector2d position);
    void solve();
    String getImage();
    boolean isSolved();
    void startSolving(IHero hero);
    void stopSolving();
    int trustLoaf();
    boolean shouldBeDestructed(int currDay);
}
