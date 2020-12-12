import java.util.ArrayList;
import java.util.List;

public class Board {
    private Coordinates boardBottomRigthCoordinates;
    private List<Zone> forbiddenZoneList;
    private Dot goalDot;
    private Coordinates dotsInitialPositionCoordinates;
    private List<Dot> dots;

    public Board(Coordinates boardBottomRigthCoordinates, Dot goalDot, Coordinates dotsInitialPositionCoordinates) {
        this.boardBottomRigthCoordinates = boardBottomRigthCoordinates;
        this.goalDot = goalDot;
        this.dotsInitialPositionCoordinates = dotsInitialPositionCoordinates;
        forbiddenZoneList = new ArrayList<>();
    }

    public Dot getGoalDot() {return goalDot;}
    public List<Dot> getDots() {
        return dots;
    }

    public void play(int numberOfRounds, int stepsByRound) {
        VectorGenerator vectorGenerator = new VectorGeneratorImpl();
        for (int i = 0; i<numberOfRounds; i++) {
            for (int j = 0; j < stepsByRound; j++) {
                for (Dot dot : dots) {
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

    public void createDots(int numDots) {
        dots = new ArrayList<>();
        for(int i=0;i<numDots;i++)
            dots.add(new Dot(dotsInitialPositionCoordinates));
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
}
