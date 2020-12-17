import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int MAX_DISTANCE = 9999;
    private final Coordinates boardBottomRigthCoordinates;
    private final Dot goalDot;
    private final Coordinates dotsInitialPositionCoordinates;
    private List<Dot> dots;
    private List<Zone> forbiddenZoneList;

    public Board(Coordinates boardBottomRigthCoordinates,
                 Coordinates goalDotCoordinates,
                 Coordinates dotsInitialPositionCoordinates,
                 int numDots) {
        this.boardBottomRigthCoordinates = boardBottomRigthCoordinates;
        this.goalDot = new Dot(goalDotCoordinates);
        this.dotsInitialPositionCoordinates = dotsInitialPositionCoordinates;
        this.dots = new ArrayList<>();
        for(int i = 0; i< numDots; i++)
            this.dots.add(new Dot(this.dotsInitialPositionCoordinates));
        forbiddenZoneList = new ArrayList<>();
    }
    public Dot getGoalDot() {return goalDot;}
    public List<Dot> getDots() {
        return dots;
    }

    public void play(int numberOfRounds, int stepsByRound) {
        VectorGenerator vectorGenerator = new VectorGeneratorImpl();
        for (int i = 0; i<numberOfRounds; i++) {
            for (Dot dot : dots) {
 //           for (int k = 0; k<dots.size(); k++){
 //               Dot dot = dots.get(k);
                for (int j = 0; j < stepsByRound; j++) {
                    if (!isDotDead(dot)) {
                        dot.move(vectorGenerator.generate());
                    }
                }
            }
        }
    }

    private boolean isDotDead(Dot dot) {
        boolean onAnyEdge = false;
        onAnyEdge = dot.onTheEdge(new Zone(new Coordinates(0,0), boardBottomRigthCoordinates));
        for(Zone forbiddenZone : forbiddenZoneList){
            onAnyEdge = onAnyEdge || dot.onTheEdge(forbiddenZone);
        }
        return onAnyEdge;
    }

    public void addForbiddenZone(Zone zone) {
        forbiddenZoneList.add(zone);
    }

    public boolean isDotOutsideForbiddenZones(Dot dot) {
        boolean isOutside = true;
        for(Zone forbiddenZone : forbiddenZoneList){
            isOutside = isOutside && dot.outsideZone(forbiddenZone);
        }

        return isOutside;
    }

    public Coordinates getBoardBottomRigthCoordinates() {
        return boardBottomRigthCoordinates;
    }

    public Zone getBoardZone() {
        return new Zone(new Coordinates(0, 0), boardBottomRigthCoordinates);
    }

    public Dot getBestDot() {
        for(Dot dot: dots){
            if(dot.isBest()) {
                return dot;
            }
        }
        return null;
    }

    public void calculateBest() {
        double bestDistance = MAX_DISTANCE;
        Dot bestDot = null;

        for(Dot dot: dots){
            double currentDistance = DistanceMeasurer.measureDistance(dot, getGoalDot());
            if(currentDistance < bestDistance){
                bestDistance = currentDistance;
                bestDot = dot;
            }
        }
        bestDot.setBest();
    }
}
