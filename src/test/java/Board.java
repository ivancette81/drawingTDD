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
        dots.get(0).move(new MyVector(1,0));
        if(stepsByRound == 2){
            dots.get(0).move(new MyVector(0,-1));
        }

    }
}
