import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceMeasurerTest {
    @Test
    public void mesasureDistance()    {
        assertEquals(DistanceMeasurer.measureDistance(new Dot(new Coordinates(0,0)), new Dot(new Coordinates(0,0))),0);
        assertEquals(DistanceMeasurer.measureDistance(new Dot(new Coordinates(0,0)), new Dot(new Coordinates(0,0))),0);
    }
}
