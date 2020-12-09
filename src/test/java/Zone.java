public class Zone {
    private Coordinates bottomLeft;
    private Coordinates topRigth;

    public Zone(int inX1, int inY1, int inX2, int inY2){
        bottomLeft = new Coordinates(Math.min(inX1, inX2), Math.min(inY1, inY2));
        topRigth = new Coordinates(Math.max(inX1, inX2), Math.max(inY1, inY2));
    }

    public boolean isInsideZone(Coordinates coordinates) {
        return bottomLeft.isInsideFirstQuadrant(coordinates) &&
                topRigth.isInsideThirdQuadrant(coordinates);
    }
    public boolean isOutsideZone(Coordinates coordinates) {
        return !bottomLeft.isInsideFirstQuadrant(coordinates) ||
                !topRigth.isInsideThirdQuadrant(coordinates);
    }

}
