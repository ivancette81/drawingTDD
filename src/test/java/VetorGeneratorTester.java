import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VetorGeneratorTester {
    @Test
    public void generate(){
        VectorGenerator vectorGenerator = new VectorGeneratorImpl();
        assertTrue(vectorGenerator.generate().equals(new MyVector(0,0)) ||
                vectorGenerator.generate().equals(new MyVector(0,1)) ||
                vectorGenerator.generate().equals(new MyVector(1,1)) ||
                vectorGenerator.generate().equals(new MyVector(1,0)) ||
                vectorGenerator.generate().equals(new MyVector(1,-1)) ||
                vectorGenerator.generate().equals(new MyVector(0,-1)) ||
                vectorGenerator.generate().equals(new MyVector(-1,-1))||
                vectorGenerator.generate().equals(new MyVector(-1,0)) ||
                vectorGenerator.generate().equals(new MyVector(-1,1))
        );
    }
}
