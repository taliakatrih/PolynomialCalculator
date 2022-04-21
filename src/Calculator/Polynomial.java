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
            else{
                exp++;
            }
        }
        Polynomial res = new Polynomial(ans);
        return res;
    }
    public Polynomial add(Polynomial p){
        Polynomial res = new Polynomial(this.monomials);
        for (java.lang.Integer key: p.monomials.keySet()){
            if(res.monomials.containsKey(key)){
                res.monomials.replace(key,res.monomials.get(key), res.monomials.get(key).add(p.monomials.get(key)));
                if(res.monomials.get(key).getCoefficient().equals(0)){
                    res.monomials.remove(key);
                }
            }
            else{
                res.monomials.put(key,p.monomials.get(key));
            }
        }
        return res;
    }
    public Polynomial mul( Polynomial p){
        Polynomial res = new Polynomial(this.monomials);
        for(java.lang.Integer keyr: res.monomials.keySet()){
            for(java.lang.Integer keyp: p.monomials.keySet()){
                Monomial n= res.monomials.get(keyr).mul(p.monomials.get(keyp));
                if(res.monomials.containsKey(n.getExponent())) {
                    res.monomials.replace(n.getExponent(), res.monomials.get(n.getExponent()), res.monomials.get(n.getExponent()).add(n));
                }
                else {
                    res.monomials.put(n.getExponent(), n);
                }
            }
        }
        return res;
    }
    public Scalar evaluate( Scalar s){
        Scalar ans = new Rational(0,1);
        for(java.lang.Integer key: this.monomials.keySet()){
            ans.add(this.monomials.get(key).evaluate(s));
        }
        return ans;
    }
    public Polynomial derivative(){
        Polynomial ans = new Polynomial(this.monomials);
        for(java.lang.Integer key: ans.monomials.keySet()){
            if(key==0){
                ans.monomials.remove(key);
            }
            Monomial der= ans.monomials.get(key).derivative();
            ans.monomials.put(der.getExponent(), der);
        }
        return ans;
    }
    public String toString(){
        String ans = "";
        for(java.lang.Integer key: this.monomials.keySet()){
            if(this.monomials.get(key).sign()==-1) {
                ans = ans.substring(0, ans.length() - 1);
            }
            ans= ans+ this.monomials.get(key).toString()+ "+";
        }
        if( ans.charAt(ans.length()-1)=='+')
            ans = ans.substring(0,ans.length()-1);

        return ans;
    }
    public boolean equals( Object ob1){
        if( ob1 instanceof Polynomial) {
            Polynomial o1 = (Polynomial) ob1;
            if(this.monomials.keySet().size() != o1.monomials.keySet().size())
                return false;
            for (java.lang.Integer key : this.monomials.keySet()) {
                if (!(o1.monomials.containsKey(key)))
                    return false;
                if (!(this.monomials.get(key).equals(o1.monomials.get(key))))
                    return false;
            }
            return true;
        }
        return false;
    }
}

