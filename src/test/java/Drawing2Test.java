import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Drawing2Test {
    @Test
    public void zeroStepsOneDot(){
        Board board = new Board();
        assertThat(board.getDots(),is(Arrays.asList(new Dot(400,800))));
    }

    @Test
    public void oneStep_OneDot(){
        Board board = new Board();
        board.play(1,1);
        assertThat(board.getDots(),is(Arrays.asList(new Dot(399,799))));
    }

    @Test
    public void twoSteps_OneDot(){
        Board board = new Board();
        board.play(1,2);
        assertThat(board.getDots(),is(Arrays.asList(new Dot(399,799))));
    }

    @Test
    public void anyStepNumber_OneDot(){
        Board board = new Board();
        int stepsByRound = (int)Math.round(Math.random()*100);
        board.play(1,stepsByRound);
        if((stepsByRound%4) == 0 || (stepsByRound%4) == 1) {
            assertThat(board.getDots(), is(Arrays.asList(new Dot(399, 799))));
        }
        else {
            assertThat(board.getDots(), is(Arrays.asList(new Dot(400, 800))));
        }
    }
}
