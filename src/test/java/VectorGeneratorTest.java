import java.util.Vector;

public class VectorGeneratorTest {
    public MyVector generate(){
        int x = RandomStepGenerator.generate();
        int y = RandomStepGenerator.generate();

        return new MyVector(x,y);
    }
}
