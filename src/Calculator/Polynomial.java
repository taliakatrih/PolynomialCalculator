package Calculator;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<java.lang.Integer,Monomial> monomials;

    public Polynomial (TreeMap<java.lang.Integer,Monomial> monomials){
        this.monomials= monomials;
    }
    public static Polynomial build( String input){
        TreeMap<java.lang.Integer, Monomial> ans = new TreeMap<>();
        java.lang.Integer exp = 0;
        for( String term: input.replaceAll("( )+", " ").split(" ")){
            if( term.charAt(0)!= '0') {
                if (term.contains("/")) {
                    int ind = term.indexOf("/");
                    Scalar n = new Rational(java.lang.Integer.parseInt(term.substring(0, ind)), java.lang.Integer.parseInt(term.substring(ind + 1)));
                    ans.put(exp, new Monomial(exp, n));
                    exp++;
                }
                else {
                    Scalar n = new Integer(java.lang.Integer.parseInt(term));
                    ans.put(exp, new Monomial(exp, n));
                    exp++;
                }
            }
        }
        Polynomial res = new Polynomial(ans);
        return res;
    }
}

