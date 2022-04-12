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
    public Rational reduce(){
        Rational ans = new Rational(getNumerator(), getDenominator());
        for(int i=2; i<= Math.min(getNumerator(), getDenominator()); i++){
            if( ans.getNumerator()%i==0 & ans.getDenominator()%i==0){
                ans.numerator= ans.getNumerator()/i;
                ans.denominator= ans.getDenominator()/i;
            }
        }
        if( ans.getNumerator()%(-1)==0 & ans.getDenominator()%(-1)==0) {
            ans.numerator = ans.getNumerator() / (-1);
            ans.denominator = ans.getDenominator() / (-1);
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
                ans = ans+ low;
            }
        }
        return ans;
    }
    public Scalar add(Scalar s){
        return s.add(this);
    }
    public Scalar addInt(Integer s){
        Scalar ans = new Rational(s.getNumber()*getDenominator()+ getNumerator(),getDenominator());
        return ans;
    }
    public Scalar addRat(Rational s){
        Scalar ans = new Rational((this.getNumerator()*s.getDenominator())+(s.getNumerator()*this.getDenominator()),this.getDenominator()*s.getDenominator());
        return ans;
    }
    public Scalar mul( Scalar s){
        return s.mul(this);
    }

    public Scalar mulInt(Integer s){
        Scalar ans = new Rational(this.getNumerator()*s.getNumber(), this.getDenominator());
        return ans;
    }

    public Scalar mulRat(Rational s){
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
}
