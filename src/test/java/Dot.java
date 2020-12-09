import java.util.Objects;

public class Dot{
    private Coordinates coordinates;

    public Dot(int x, int y) {
        coordinates = new Coordinates(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Objects.equals(coordinates, dot.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "coordinates=" + coordinates +
                '}';
    }

    public void move(MyVector myVector) {
        coordinates.applyVector(myVector);
    }

    public boolean betweenBoundaries(int width, int heigth) {
        return coordinates.isInsideSecondQuadrant(width, heigth) &&
                coordinates.isInsideFourthQuadrant(0, 0);
    }

    public boolean outsideZone(Zone zone) {
        return zone.isOutsideZone(coordinates);
    }

    public boolean isDead(int width, int heigth) {
        Zone board = new Zone(0,width,0,heigth);
        return board.isOutsideZone(coordinates);
    }
}
