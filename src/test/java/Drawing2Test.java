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
    public void oneStepsOneDot(){
        Board board = new Board();
        board.play(1,1);
        assertThat(board.getDots(),is(Arrays.asList(new Dot(401,800))));
    }

    @Test
    public void twoStepsOneDot(){
        Board board = new Board();
        board.play(1,2);
        assertThat(board.getDots(),is(Arrays.asList(new Dot(401,799))));
    }
}
