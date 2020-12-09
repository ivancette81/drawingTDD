import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width;
    private int heigth;
    private List<Zone> forbiddenZoneList;

    public int getWidth() {return width;}
    public int getHeigth() {return heigth;}

    private Dot goalDot;
    public void setGoalDot(Dot dot) {goalDot = dot;}
    public Dot getGoalDot() {return goalDot;}

    private int dotsInitialPositionX;
    private int dotsInitialPositionY;

    private List<Dot> dots;

    public Board(int _width, int _heigth) {
        width = _width;
        heigth = _heigth;

        forbiddenZoneList = new ArrayList<>();
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void play(int numberOfRounds, int stepsByRound) {
        VectorGenerator vectorGenerator = new VectorGeneratorImpl();
        for( int i=0; i<stepsByRound; i++) {
            if(!isDotDead(dots.get(0))) {
                dots.get(0).move(vectorGenerator.generate());
            }
        }
    }

    private boolean isDotDead(Dot dot) {
        return !dot.isDead(width, heigth);
    }

    public void setDotsInitialPosition(int inX, int inY) {
        dotsInitialPositionX = inX;
        dotsInitialPositionY = inY;
    }

    public void createDots(int numDots) {
        dots = new ArrayList<>();
        for(int i=0;i<numDots;i++)
            dots.add(new Dot(dotsInitialPositionX, dotsInitialPositionY));
    }

    public void setForbiddenZone(Zone zone) {
        forbiddenZoneList.add(zone);
    }

}
