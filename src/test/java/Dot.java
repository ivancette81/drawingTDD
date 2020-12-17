import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dot {
    private Coordinates coordinates;
    private boolean isBestDot;
    private List<MyVector> movements;

    public Dot(Coordinates coordinates) {
        this.coordinates = new Coordinates(coordinates.getX(), coordinates.getY()) ;
        isBestDot = false;
        movements = new ArrayList<>();
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
        movements.add(myVector);
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isBest() {
        return isBestDot;
    }

    public void setBest() {
        isBestDot = true;
    }
}
