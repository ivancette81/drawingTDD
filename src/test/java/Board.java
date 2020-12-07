import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Dot> dots;

    public Board() {
        this.dots = new ArrayList<>();
        dots.add(new Dot(400,800));
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void play(int numberOfRounds, int stepsByRound) {
        VectorGeneratorTest vectorGenerator = new VectorGeneratorTest(0,0);
        for( int i=0; i<stepsByRound; i++) {
            dots.get(0).move(vectorGenerator.generate());
        }
    }
}
