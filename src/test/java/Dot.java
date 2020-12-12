import java.util.Objects;

public class Dot{
    private Coordinates coordinates;

    public Dot(Coordinates coordinates) {
        this.coordinates = coordinates;
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

    public boolean outsideZone(Zone zone) {
        return !zone.isInsideZone(coordinates);
    }

    public boolean insideZone(Zone zone) {
        return zone.isInsideZone(coordinates);
    }

    public boolean onTheEdge(Zone zone) {
        return zone.onTheEdge(coordinates);
    }
}
