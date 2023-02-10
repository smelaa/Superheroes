package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public Vector2d toUnitVector(){
        Vector2d u=switch(this){
            case FORWARD -> new Vector2d(0,1);
            case BACKWARD -> new Vector2d(0,-1);
            case RIGHT -> new Vector2d(-1,0);
            case LEFT -> new Vector2d(1,0);
        };
        return u;
    }
}