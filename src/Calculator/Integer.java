package Calculator;

public class Integer implements Scalar {
    private int number;

    public Integer(int num)
    {
        this.number =num;
    }

    public int getNumber() {
        return number;
    }

    public String toString(){
        String ans = " " + getNumber();
        return ans;
    }
    public Scalar add(Scalar s){
        return s.add(this);
    }
    public Scalar addInt(Integer s){
        Scalar ans = new Integer(getNumber()+ s.getNumber());
        return ans;
    }
    public Scalar addRat(Rational s){
        Scalar ans = new Rational(getNumber()*s.getDenominator()+ s.getNumerator(),s.getDenominator());
        return ans;
    }
    public Scalar mul(Scalar s){
        return s.mul(this);
    }
    public Scalar mulInt( Integer s){
        Scalar ans = new Integer(getNumber()* s.getNumber());
        return ans;
    }
    public Scalar mulRat(Rational s){
        Scalar ans = new Rational((getNumber()*s.getDenominator()+ s.getNumerator()),s.getDenominator());
        return ans;

    }
    public Scalar neg(){
        Integer min1= new Integer(-1);
        Scalar ans=this.mul(min1);
        return ans;
    }
    public Scalar power(int exponent){
        Scalar ans= new Integer((int)Math.pow(this.getNumber(), exponent));
        return ans;
    }
    public int sign(){
        return (int) Math.signum((int)this.getNumber());
    }
}
