package Calculator;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar addInt (Integer s);
    public Scalar addRat (Rational s);
    public Scalar mul( Scalar s);
    public Scalar mulInt( Integer s);
    public Scalar mulRat( Rational s);
    public Scalar neg();
    public Scalar power(int exponent);
    public int sign();
}
