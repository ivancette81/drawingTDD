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
}
