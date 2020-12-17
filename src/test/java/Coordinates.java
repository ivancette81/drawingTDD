import java.util.Objects;

public class Coordinates {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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

    public boolean inSecondQuadrant(Coordinates coordinates) {
        return coordinates.x > x && coordinates.y > y;
    }

    public boolean inFourthQuadrant(Coordinates coordinates) {
        return coordinates.x < x && coordinates.y < y;
    }

    public void applyVector(MyVector myVector) {
        x = myVector.applyX(x);
        y = myVector.applyY(y);
    }

    public boolean onTheEdge(Coordinates topLeft, Coordinates bottomRigth) {
        return x == topLeft.x || x == bottomRigth.x ||
                y == topLeft.y || y == bottomRigth.y;
    }
}
