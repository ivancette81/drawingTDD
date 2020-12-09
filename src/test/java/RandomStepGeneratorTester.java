import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomStepGeneratorTester {
    @Test
    public void randomStep(){
        RandomStepGenerator stepGenerator = new RandomStepGeneratorImpl();
        int step = stepGenerator.generate();
        assertTrue( step == 0 ||
                step == 1 ||
                step == -1);
    }
}
