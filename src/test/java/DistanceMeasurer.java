public class DistanceMeasurer {

    public static double measureDistance(Dot dot, Dot goalDot) {
        return Math.sqrt(getHypothenuseToTheSquare(dot, goalDot));
    }

    private static double getHypothenuseToTheSquare(Dot dot, Dot goalDot) {
        return getCathetusToTheSquare(dot.getCoordinates().getX()-goalDot.getCoordinates().getX())
                + getCathetusToTheSquare(dot.getCoordinates().getY()-goalDot.getCoordinates().getY());
    }

    private static double getCathetusToTheSquare(int cathetus_length) {
        return Math.pow(cathetus_length, 2);
    }
}