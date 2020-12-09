public class VectorGeneratorImpl implements VectorGenerator{
    public MyVector generate()
    {   RandomStepGenerator stepGenerator = new RandomStepGeneratorImpl();
        return new MyVector(stepGenerator.generate(),stepGenerator.generate());
    }
}
