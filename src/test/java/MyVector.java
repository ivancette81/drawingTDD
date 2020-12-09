import java.util.Objects;

public class MyVector {
    private int x;
    private int y;

    public MyVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int applyX(int x) {
        return this.x+x;
    }

    public int applyY(int y) {
        return this.y+y;
    }

    @Override
    public String toString() {
        return "MyVector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyVector myVector = (MyVector) o;
        return x == myVector.x && y == myVector.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
