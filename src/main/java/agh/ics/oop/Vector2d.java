package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    private final int x;
    private final int y;
    public Vector2d (int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }

    public boolean precedes(Vector2d other) {
        return x <= other.x && y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return x >= other.x && y >= other.y;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(-x, -y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2d other = (Vector2d) obj;
        return (x == other.x && y == other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
