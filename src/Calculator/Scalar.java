package Calculator;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar add (Integer s);
    public Scalar mul( Scalar s);
    public Scalar mul( Integer s);
    public Scalar neg();
    public Scalar power(int exponent);
    public Scalar sign();
}
