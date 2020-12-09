import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Drawing2Test {
    @Test
    public void createBoard(){
        Board board = new Board(800, 800);
        assertEquals(board.getWidth(), 800);
        assertEquals(board.getHeigth(), 800);
    }
    @Test
    public void createGoalDot(){
        Board board = new Board(800, 800);
        Dot dot = new Dot(0,400);
        board.setGoalDot(dot);

        assertTrue(board.getGoalDot().equals(dot));
    }

    @Test
    public void createOneDotInDotsInitialPosition(){
        Board board = new Board(800, 800);
        board.setDotsInitialPosition(400,800);
        board.createDots(1);

        assertEquals(Arrays.asList(new Dot(400,800)),board.getDots());
    }

    @Test
    public void oneDot_OneStep_OneRound(){
        Board board = new Board(800,800);
        board.setDotsInitialPosition(400,800);
        board.createDots(1);
        board.play(1,1);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.equals(new Dot(400,800)) ||
                        dot.equals(new Dot(400,801)) ||
                        dot.equals(new Dot(400,799)) ||
                        dot.equals(new Dot(399,800)) ||
                        dot.equals(new Dot(399,801)) ||
                        dot.equals(new Dot(399,799)) ||
                        dot.equals(new Dot(401,800)) ||
                        dot.equals(new Dot(401,801)) ||
                        dot.equals(new Dot(401,799))
                );

    }
    @Test
    public void oneDot_OneStep_OneRound_WithLimits(){
        Board board = new Board(800,800);
        board.setDotsInitialPosition(400,795);
        board.createDots(1);
        board.play(1,1);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.betweenBoundaries(800,800));
    }

    @Test
    public void oneDot_AnyNumberOfSteps_OneRound_WithLimits(){
        Board board = new Board(800,800);
        board.setDotsInitialPosition(400,795);
        board.createDots(1);
        board.play(1,2000);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.betweenBoundaries(800,800));
    }
    @Test
    public void oneDot_AnyNumberOfSteps_OneRound_OneForbiddenZone(){
        Board board = new Board(800,800);
        board.setDotsInitialPosition(400,795);
        board.createDots(1);

        Zone zone = new Zone(200, 700, 600, 750);
        board.setForbiddenZone(zone);

        board.play(1,2000);

        Dot dot = board.getDots().get(0);
        assertTrue(dot.betweenBoundaries(800,800));
        assertTrue(dot.outsideZone(zone));
    }
/*
    @Test
    public void twoSteps_OneDot(){
        Board board = new Board(800,800);
        board.play(1,2);
        assertThat(board.getDots(),is(Arrays.asList(new Dot(399,799))));
    }

    @Test
    public void anyStepNumber_OneDot(){
        Board board = new Board(800,800);
        int stepsByRound = (int)Math.round(Math.random()*100);
        board.play(1,stepsByRound);
        if((stepsByRound%4) == 0 || (stepsByRound%4) == 1) {
            assertThat(board.getDots(), is(Arrays.asList(new Dot(399, 799))));
        }
        else {
            assertThat(board.getDots(), is(Arrays.asList(new Dot(400, 800))));
        }
    }*/
}
