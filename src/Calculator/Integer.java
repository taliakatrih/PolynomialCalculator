package Calculator;

public class Integer implements Scalar {
    private int number;

    public Integer(int num)
    {
        this.number =num;
    }
    public String toString(){
        String ans = " " + number;
        return ans;
    }
    public Scalar add(Scalar s){
        return s.add(this);
    }
    public Scalar add(Integer s){
        Scalar ans = new Integer(number+ s.number);
        return ans;
    }
    public Scalar mul( Scalar s){
        return s.mul(this);
    }
    public Scalar mul( Integer s){
        Scalar ans = new Integer(number* s.number);
        return ans;
    }
    Scalar neg(){

    }
    Scalar power(int exponent){

    }
    Scalar sign(){

    }
}
