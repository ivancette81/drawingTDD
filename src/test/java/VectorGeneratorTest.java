public class VectorGeneratorTest implements VectorGenerator {
    private int x;
    private int y;

    public VectorGeneratorTest(int inX, int inY){
        x = inX;
        y = inY;
    }
    public MyVector generate(){
        int randomX = (x++ % 3) - 1;
        int randomY = (y++ % 3) - 1;

        return new MyVector(randomX,randomY);
    }
}
