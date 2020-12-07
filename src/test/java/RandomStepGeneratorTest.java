import java.util.Random;

public class RandomStepGeneratorTest {
    private Random generator;

    public RandomStepGeneratorTest(int seed){
        generator = new Random(seed);
    }
    public int generate(){
        double nextRandom = generator.nextDouble();
        int nextRandom_OneToTen = (int)Math.round(nextRandom * 10);
        int ret = (nextRandom_OneToTen % 3) - 1;
        return ret;

    }
}
