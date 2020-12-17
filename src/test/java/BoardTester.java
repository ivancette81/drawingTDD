import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTester {
    @Test
    public void isDotOutsideForbiddenZones_OneZone(){
        Board board = new Board(new Coordinates(800, 800),
                null,
                null,
                        0);
        Zone forbiddenZone = new Zone (new Coordinates(Math.min(200, 600), Math.min(200, 600)), new Coordinates(Math.max(200, 600), Math.max(200, 600)));
        board.addForbiddenZone(forbiddenZone);

        assertFalse(board.isDotOutsideForbiddenZones(new Dot(new Coordinates(500, 500))));
        assertTrue(board.isDotOutsideForbiddenZones(new Dot(new Coordinates(0, 0))));
        assertTrue(board.isDotOutsideForbiddenZones(new Dot(new Coordinates(800, 800))));
    }

}
