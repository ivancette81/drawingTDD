public class RandomStepGenerator {
    public static int generate(){
        int ret = (int)Math.round(Math.random())%3 - 1;
        return ret;
    }
}
