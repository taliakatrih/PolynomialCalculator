package Calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {

    private TreeMap<java.lang.Integer, Monomial> m1;
    private TreeMap<java.lang.Integer, Monomial> m2;
    private TreeMap<java.lang.Integer, Monomial> m3;
    private TreeMap<java.lang.Integer, Monomial> m4;
    private TreeMap<java.lang.Integer, Monomial> m5;
    @Before
    public void setUp(){
        m1 = new TreeMap<>();
        m1.put(0,new Monomial(0,new Integer(1)));
        m1.put(1,new Monomial(1,new Integer(2)));
        m1.put(2,new Monomial(2,new Integer(3)));
        m2 = new TreeMap<>();
        m2.put(1,new Monomial(1,new Integer(1)));
        m2.put(2,new Monomial(2,new Integer(2)));
        m2.put(3,new Monomial(3,new Integer(3)));
        m3 = new TreeMap<>();
        m3.put(0,new Monomial(0,new Integer(0)));
        m3.put(1,new Monomial(1,new Integer(0)));
        m3.put(2,new Monomial(2,new Integer(0)));
        m3.put(3,new Monomial(3,new Integer(0)));
        m3.put(4,new Monomial(4,new Integer(0)));
        m3.put(5,new Monomial(5,new Integer(0)));
        m3.put(6,new Monomial(6,new Integer(0)));
        m3.put(7,new Monomial(7,new Integer(7)));
        m4 = new TreeMap<>();
        m4.put(0,new Monomial(0,new Integer(1)));
        m4.put(1,new Monomial(1,new Integer(-2)));
        m4.put(2,new Monomial(2,new Integer(3)));
        m5 = new TreeMap<>();
        m5.put(0,new Monomial(0,new Integer(0)));
        m5.put(1,new Monomial(1,new Rational(1,2)));
        m5.put(2,new Monomial(2,new Integer(3)));
        m5.put(3,new Monomial(3,new Rational(-5,3)));
    }
    @Test
    public void testToString() {
        Polynomial p1 = new Polynomial(m1);
        Polynomial p2 = new Polynomial(m2);
        Polynomial p3 = new Polynomial(m3);
        Polynomial p4 = new Polynomial(m4);
        Polynomial p5 = new Polynomial(m5);
        assertEquals("toString is wrong", "1+2x+3x^2",p1.toString());
        assertEquals("toString is wrong", "x+2x^2+3x^3",p2.toString());
        assertEquals("toString is wrong", "7x^6",p3.toString());
        assertEquals("toString is wrong", "1-2x+3x^2",p4.toString());
        assertEquals("toString is wrong", "1/2x+3x^2-5/3x^3",p5.toString());
    }

    @Test
    public void build(String s) {
        Polynomial expected1 = new Polynomial(m1);
        Polynomial expected2 = new Polynomial(m2);
        Polynomial expected3 = new Polynomial(m2);
        Polynomial expected4 = new Polynomial(m2);
        Polynomial expected5 = new Polynomial(m2);
        assertEquals((Object) expected1, (Object) Polynomial.build("1 2 3"));
        assertEquals((Object) expected2, (Object) Polynomial.build("0 1 2 3"));
        assertEquals((Object) expected3, (Object) Polynomial.build("0 0 0 0 0 0 7"));
        assertEquals((Object) expected4, (Object) Polynomial.build("1 -2 3"));
        assertEquals((Object) expected5, (Object) Polynomial.build("0 1/2 3 -5/3"));
    }
    @Test
    public void add() {
        TreeMap<java.lang.Integer, Monomial> x1 = new TreeMap<>();
        x1.put(0,new Monomial(0,new Integer(1)));
        x1.put(1,new Monomial(1,new Integer(3)));
        x1.put(2,new Monomial(2,new Integer(5)));
        x1.put(3,new Monomial(3,new Integer(3)));
        Polynomial expected1= new Polynomial(x1);
        Polynomial p1 = new Polynomial(m1);
        Polynomial p2 = new Polynomial(m2);
        assertEquals((Object) expected1, (Object) p1.add(p2));
        TreeMap<java.lang.Integer, Monomial> x2 = new TreeMap<>();
        x2.put(0,new Monomial(0,new Integer(1)));
        x2.put(1,new Monomial(1,new Rational(-3,2)));
        x2.put(2,new Monomial(2,new Integer(6)));
        x2.put(3,new Monomial(3,new Rational(-5,3)));
        Polynomial expected2= new Polynomial(x2);
        Polynomial p4 = new Polynomial(m4);
        Polynomial p5 = new Polynomial(m5);
        assertEquals((Object) expected2, (Object) p4.add(p5));
    }
    @Test
    public void mul() {
        TreeMap<java.lang.Integer, Monomial> x1 = new TreeMap<>();
        x1.put(0,new Monomial(0,new Integer(0)));
        x1.put(1,new Monomial(1,new Integer(1)));
        x1.put(2,new Monomial(2,new Integer(4)));
        x1.put(3,new Monomial(3,new Integer(10)));
        x1.put(4,new Monomial(4,new Integer(12)));
        x1.put(5,new Monomial(5,new Integer(9)));
        Polynomial expected1= new Polynomial(x1);
        Polynomial p1 = new Polynomial(m1);
        Polynomial p2 = new Polynomial(m2);
        assertEquals((Object) expected1, (Object) p1.mul(p2));
        TreeMap<java.lang.Integer, Monomial> x2 = new TreeMap<>();
        x2.put(0,new Monomial(0,new Integer(0)));
        x2.put(1,new Monomial(1,new Rational(1,2)));
        x2.put(2,new Monomial(2,new Integer(2)));
        x2.put(3,new Monomial(3,new Rational(35,6)));
        x1.put(4,new Monomial(4,new Rational(37,3)));
        x1.put(5,new Monomial(5,new Integer(-5)));
        Polynomial expected2= new Polynomial(x2);
        Polynomial p4 = new Polynomial(m4);
        Polynomial p5 = new Polynomial(m5);
        assertEquals((Object) expected2, (Object) p4.mul(p5));
    }
    @Test
    public void evaluate() {
        Scalar expected1 = new Integer(448);
        Polynomial p3 = new Polynomial(m3);
        assertEquals((Object) expected1, (Object) p3.evaluate(new Integer(2)));
        Scalar expected2 = new Integer(9);
        Polynomial p4 = new Polynomial(m4);
        assertEquals((Object) expected2, (Object) p4.evaluate(new Integer(2)));
    }
    @Test
    public void derivative() {
        TreeMap<java.lang.Integer, Monomial> x1 = new TreeMap<>();
        x1.put(0,new Monomial(0,new Rational(1,2)));
        x1.put(1,new Monomial(1,new Integer(6)));
        x1.put(2,new Monomial(2,new Integer(-5)));
        Polynomial expected1= new Polynomial(x1);
        Polynomial p5 = new Polynomial(m5);
        assertEquals((Object) expected1, (Object) p5.derivative());
    }

}