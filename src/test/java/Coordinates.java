import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isInsideFirstQuadrant(Coordinates coordinates) {
        return coordinates.x >= this.x && coordinates.y <= this.y;
    }

    public boolean isInsideThirdQuadrant(Coordinates coordinates) {
        return coordinates.x <= this.x && coordinates.y >= this.y;
    }

    public boolean isInsideSecondQuadrant(int x, int y) {
        return x >= this.x && y >= this.y;
    }

    public boolean isInsideFourthQuadrant(int x, int y) {
        return x <= this.x && y <= this.y;
    }

    public void applyVector(MyVector myVector) {
        x = myVector.applyX(x);
        y = myVector.applyY(y);
    }
}
