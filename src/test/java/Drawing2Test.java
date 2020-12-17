import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Drawing2Test {

    public static final int ZERO = 0;
    public static final int MAX_DIMENSION = 800;

    @Test
    public void createBoard(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                null,
                        0);
        assertEquals(board.getBoardBottomRigthCoordinates(), new Coordinates(MAX_DIMENSION, MAX_DIMENSION));
    }
    @Test
    public void createGoalDot(){
        Dot dot = new Dot(new Coordinates(0, MAX_DIMENSION/2));
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                dot.getCoordinates(),
                null,
                        0);

        assertTrue(board.getGoalDot().equals(dot));
    }

    @Test
    public void createOneDotInDotsInitialPosition(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2, MAX_DIMENSION),
                        1);

        assertEquals(Arrays.asList(new Dot(new Coordinates(MAX_DIMENSION/2, MAX_DIMENSION))),board.getDots());
    }

    @Test
    public void oneDot_OneStep_OneRound(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        1);
        board.play(1,1);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.equals(new Dot(new Coordinates(400, 795))) ||
                        dot.equals(new Dot(new Coordinates(400, 796))) ||
                        dot.equals(new Dot(new Coordinates(400, 794))) ||
                        dot.equals(new Dot(new Coordinates(399, 795))) ||
                        dot.equals(new Dot(new Coordinates(399, 796))) ||
                        dot.equals(new Dot(new Coordinates(399, 794))) ||
                        dot.equals(new Dot(new Coordinates(401, 795))) ||
                        dot.equals(new Dot(new Coordinates(401, 796))) ||
                        dot.equals(new Dot(new Coordinates(401, 794)))
                );

    }
    @Test
    public void oneDot_OneStep_OneRound_WithLimits(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        1);

        board.play(1,1);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.insideZone(board.getBoardZone()));
    }

    @Test
    public void oneDot_AnyNumberOfSteps_OneRound_WithLimits(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        1);

        board.play(1,2000);
        Dot dot = board.getDots().get(0);
        assertTrue(dot.insideZone(board.getBoardZone()) ||
                dot.onTheEdge(board.getBoardZone())
        );
    }
    @Test
    public void oneDot_AnyNumberOfSteps_OneRound_OneForbiddenZone(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        1);

        Zone forbiddenZone = new Zone(new Coordinates(ZERO, Math.min(700, 750)), new Coordinates(MAX_DIMENSION, Math.max(700, 750)));
        board.addForbiddenZone(forbiddenZone);

        board.play(1,2000);

        Dot dot = board.getDots().get(0);
        assertTrue(dot.insideZone(board.getBoardZone()) || dot.onTheEdge(board.getBoardZone()));
        assertTrue(dot.outsideZone(forbiddenZone));
    }

    @Test
    public void oneDot_AnyNumberOfSteps_OneRound_AnyNumberOfForbiddenZone(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        1);


        Zone forbiddenZone;
        for (int i=0; i<4; i++)
        {
            forbiddenZone = new Zone(new Coordinates(0, Math.min(700, 750)), new Coordinates(Math.max(0, MAX_DIMENSION /(i+1)), Math.max(700, 750)));
            board.addForbiddenZone(forbiddenZone);
        }

        board.play(1,2000);

        Dot dot = board.getDots().get(0);
        assertTrue(dot.insideZone(board.getBoardZone()) || dot.onTheEdge(board.getBoardZone()));
        assertTrue(board.isDotOutsideForbiddenZones(dot));
    }

    @Test
    public void AnyNumberOfDots_AnyNumberOfSteps_OneRound_AnyNumberOfForbiddenZone(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        50);

        Zone forbiddenZone;
        for (int i=0; i<4; i++)
        {
            forbiddenZone = new Zone(new Coordinates(0, Math.min(700, 750)), new Coordinates(Math.max(0, MAX_DIMENSION /(i+1)), Math.max(700, 750)));
            board.addForbiddenZone(forbiddenZone);
        }

        board.play(1,2000);

        for (Dot dot : board.getDots()) {
            assertTrue(dot.insideZone(board.getBoardZone()) || dot.onTheEdge(board.getBoardZone()));
            assertTrue(board.isDotOutsideForbiddenZones(dot));
        }
    }

    @Test
    public void AnyNumberOfDots_AnyNumberOfSteps_AnyNumberOfRounds_AnyNumberOfForbiddenZone(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                null,
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
                        50);

        Zone forbiddenZone;
        for (int i=0; i<4; i++){
            forbiddenZone = new Zone(new Coordinates(0, Math.min(700, 750)), new Coordinates(Math.max(0, MAX_DIMENSION /(i+1)), Math.max(700, 750)));
            board.addForbiddenZone(forbiddenZone);
        }

        board.play(50,2000);

        for (Dot dot : board.getDots()) {
            assertTrue(dot.insideZone(board.getBoardZone()) || dot.onTheEdge(board.getBoardZone()));
            assertTrue(board.isDotOutsideForbiddenZones(dot));
        }
    }
    @Test
    public void distance_oneDot_to_goalDot(){
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                new Coordinates(MAX_DIMENSION/2, 0),
                new Coordinates(MAX_DIMENSION/2,MAX_DIMENSION-5),
               1);

        assertEquals(DistanceMeasurer.measureDistance(board.getDots().get(0), board.getGoalDot()), MAX_DIMENSION-5);
    }

    @Test
    public void get_best_between_two_dots() {
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                new Coordinates(MAX_DIMENSION / 2, 0),
                new Coordinates(MAX_DIMENSION / 2, MAX_DIMENSION - 5),
                2);
        board.play(1, 10);
        board.calculateBest();

        double distanceDot0 = DistanceMeasurer.measureDistance(board.getDots().get(0), board.getGoalDot());
        double distanceDot1 = DistanceMeasurer.measureDistance(board.getDots().get(1), board.getGoalDot());

        if (distanceDot0 <= distanceDot1) {
            assertTrue(board.getBestDot().equals(board.getDots().get(0)));
        } else{
            assertTrue(board.getBestDot().equals(board.getDots().get(1)));
        }
    }

    //este test no testea nada. Ya tienes los movimientos guardados, puedes mutarlos para la siguiente ronda
    @Test
    public void save_dot_movements() {
        Board board = new Board(new Coordinates(MAX_DIMENSION, MAX_DIMENSION),
                new Coordinates(MAX_DIMENSION / 2, 0),
                new Coordinates(MAX_DIMENSION / 2, MAX_DIMENSION - 5),
                2);
        board.play(1, 10);

    }

}
