public class Zone {
    private Coordinates topLeft;
    private Coordinates bottomRigth;

    public Zone(Coordinates topLeft, Coordinates bottomRigth){
        this.topLeft = topLeft;
        this.bottomRigth = bottomRigth;
    }

    public boolean isInsideZone(Coordinates coordinates) {
        return topLeft.inSecondQuadrant(coordinates) &&
                bottomRigth.inFourthQuadrant(coordinates);
    }

    public boolean onTheEdge(Coordinates coordinates) {
        return coordinates.onTheEdge(topLeft, bottomRigth);
    }
}
