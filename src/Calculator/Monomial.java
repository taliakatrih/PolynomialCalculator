package Calculator;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial( int exp, Scalar coe){
        this.exponent= exp;
        this.coefficient= coe;
    }
    public int getExponent() {
        return exponent;
    }
    public Scalar getCoefficient() {
        return coefficient;
    }
    public Monomial add(Monomial m){
        if( this.getExponent() != m.getExponent())
            return null;
        Monomial ans = new Monomial(this.getExponent(),this.getCoefficient().add(m.getCoefficient()));
        return ans;
    }
    public Monomial mul(Monomial m){
        if(m.getExponent()==0 & this.getExponent()==0 ){
            Monomial ans = new Monomial(m.getExponent(), this.getCoefficient().mul(m.getCoefficient()));
            return ans;
        }
        else if(m.getExponent()==0 ){
            Monomial ans = new Monomial(m.getExponent(), this.getCoefficient());
            return ans;
        }
        else if( this.getExponent()==0) {
            Monomial ans = new Monomial(this.getExponent(), m.getCoefficient());
            return ans;
        }
        else {
            Monomial ans = new Monomial(m.getExponent() * this.getExponent(), this.getCoefficient().mul(m.getCoefficient()));
            return ans;
        }
    }
    public Scalar evaluate(Scalar s){
        Scalar ans = this.getCoefficient().mul(s.power(this.getExponent()));
        return ans;
    }
    public Monomial derivative(){
        Integer exp= new Integer(this.getExponent());
        if(exp.getNumber()==0){
            Scalar zero = new Integer(0);
            Monomial ans = new Monomial(0,zero);
            return ans;
        }
        else if(exp.getNumber()==1){
            Monomial ans= new Monomial(0,this.getCoefficient());
            return ans;
        }
        else {
            Monomial ans = new Monomial(this.getExponent() - 1, this.getCoefficient().mul(exp));
            return ans;
        }
    }
    public int sign(){
        return this.coefficient.sign();
    }

    public String toString(){
        String ans ="";
        if( this.getExponent()==0)
            return this.getCoefficient().toString();
        if( this.getExponent()==1)
            return this.getCoefficient().toString() +"x";
        if( this.getCoefficient().toString().equals("1")){
            ans = ans+ "x^" + this.getExponent();
        }
        else if( this.getCoefficient().toString().equals("-1")){
            ans = ans+ "-x^" + this.getExponent();
        }
        else
            ans = ans + this.getCoefficient().toString() + "x ^" + this.getExponent();
        return ans;
    }
}
