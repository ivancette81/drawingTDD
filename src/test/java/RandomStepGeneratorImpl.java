public class RandomStepGeneratorImpl implements RandomStepGenerator {
    public int generate(){
        int ret = (int)Math.round(Math.random()*10)%3 - 1;
        return ret;
    }
}
