package Calculator;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator){
        this.numerator= numerator;
        this.denominator= denominator;
    }
    public int getDenominator() {
        return denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Rational reduce(){
        Rational ans = new Rational(getNumerator(), getDenominator());

        for(int i=2; i<= Math.min(getNumerator(), getDenominator()); i++){
            if( ans.getNumerator()%i==0 & ans.getDenominator()%i==0){
                ans.numerator= ans.getNumerator()/i;
                ans.denominator= ans.getDenominator()/i;
            }
        }
        if( ans.getNumerator()<0 & ans.getDenominator()<0) {
            ans.neg();
        }
        return ans;
    }
    public String toString(){
        String ans = "";
        if(getNumerator()%getDenominator()==0){
            int div = getNumerator()/getDenominator();
            ans = ans+ div;
        }
        else{
            if(getNumerator()==0)
                ans = ans +'0';
            else{
                Rational low = this.reduce();
                if(low.getDenominator()<0){
                    low.setNumerator(0- low.getNumerator());
                    low.setDenominator(0-low.getDenominator());
                }
                ans = ans+ low.getNumerator()+ "/" + low.getDenominator();
            }
        }
        return ans;
    }
    public Scalar add(Scalar s){
        return s.add(this);
    }
    public Scalar add(Integer s){
        Scalar ans = new Rational(s.getNumber()*getDenominator()+ getNumerator(),getDenominator());
        return ans;
    }
    public Scalar add(Rational s){
        Scalar ans = new Rational((this.getNumerator()*s.getDenominator())+(s.getNumerator()*this.getDenominator()),this.getDenominator()*s.getDenominator());
        return ans;
    }
    public Scalar mul( Scalar s){
        return s.mul(this);
    }

    public Scalar mul(Integer s){
        Scalar ans = new Rational(this.getNumerator()*s.getNumber(), this.getDenominator());
        return ans;
    }

    public Scalar mul(Rational s){
        Scalar ans = new Rational(s.getNumerator()*this.getNumerator(), s.getDenominator()*this.getDenominator());
        return ans;
    }
    public Scalar neg(){
        Integer min1= new Integer(-1);
        Scalar ans=this.mul(min1);
        return ans;
    }
    public Scalar power(int exponent){
        Scalar ans = new Rational((int)Math.pow(this.getNumerator(), exponent),(int)Math.pow(this.getDenominator(),exponent));
        return ans;
    }
    public int sign(){
        if(this.getNumerator()*this.getDenominator()>0)
            return 1;
        else if(this.getNumerator()*this.getDenominator()==0)
            return 0;
        else return -1;
    }
    public boolean equals( Object ob1){
        if( ob1 instanceof Rational){
            return (((Rational) ob1).getNumerator()==this.getNumerator()) && (((Rational) ob1).getDenominator()== this.getDenominator())  ;
        }
        else
            return false;
    }
}
