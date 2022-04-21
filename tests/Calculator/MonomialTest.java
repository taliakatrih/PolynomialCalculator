package Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonomialTest {

    private Monomial test34;
    private Monomial testm24;
    private Monomial testm21;
    private Monomial test52;
    private Monomial test40;
    private Monomial test02;
    private Monomial test12;

    @Before
    public void setUp() {
        test34 = new Monomial(4,new Integer(3));
        testm24 = new Monomial(4,new Integer(-2));
        testm21 = new Monomial(1,new Integer(-2));
        test52 = new Monomial(2,new Integer(5));
        test40 = new Monomial(0,new Integer(4));
        test02 = new Monomial(2,new Integer(0));
        test12 = new Monomial(2,new Integer(1));
    }

    @Test
    public void testToString() {
        assertEquals("toString is wrong", "3x^4",test34.toString());
        assertEquals("toString is wrong", "-2x^4",testm24.toString());
        assertEquals("toString is wrong", "-2x",testm21.toString());
        assertEquals("toString is wrong", "0",test02.toString());
        assertEquals("toString is wrong", "x^2",test12.toString());
    }

    @Test
    public void sign() {
        java.lang.Integer expected1= 0;
        java.lang.Integer expected2= 1;
        java.lang.Integer expected3= -1;
        assertEquals((Object) expected1, (Object) test02.sign());
        assertEquals((Object) expected2, (Object) test34.sign());
        assertEquals((Object) expected3, (Object) testm24.sign());
    }

    @Test
    public void derivative() {
        Monomial expected1 = new Monomial(3,new Integer(12));
        Monomial expected2 = new Monomial(3, new Integer(-8));
        Monomial expected3 = new Monomial(0, new Integer(0));
        Monomial expected4 = new Monomial(0, new Integer(-2));
        assertEquals((Object) expected1, (Object) test34.derivative());
        assertEquals((Object) expected2, (Object) testm24.derivative());
        assertEquals((Object) expected3, (Object) test40.derivative());
        assertEquals((Object) expected4, (Object) testm21.derivative());
    }
    @Test
    public void evaluate() {
        Scalar expected1 = new Integer(3);
        Scalar expected2 = new Rational(-32,81);
        Scalar expected3 = new Integer(0);
        assertEquals((Object) expected1, (Object) test34.evaluate(new Integer(1)));
        assertEquals((Object) expected2, (Object) testm24.evaluate(new Rational(2,3)));
        assertEquals((Object) expected3, (Object) test02.evaluate(new Integer(5)));
    }

    @Test
    public void mul() {
        Monomial expected1 = new Monomial(8,new Integer(-6));
        Monomial expected2 = new Monomial(6, new Integer(-10));
        Monomial expected3 = new Monomial(2, new Integer(20));
        assertEquals((Object) expected1, (Object) test34.mul(testm24));
        assertEquals((Object) expected2, (Object) testm24.mul(test52));
        assertEquals((Object) expected3, (Object) test40.mul(test52));

    }
    @Test
    public void add() {
        Monomial expected1 = new Monomial(4,new Integer(1));
        Monomial expected2 = null;
        Monomial expected3 = new Monomial(2, new Integer(5));
        assertEquals((Object) expected1, (Object) test34.add(testm24));
        assertEquals((Object) expected2, (Object) testm24.add(test52));
        assertEquals((Object) expected3, (Object) test02.add(test52));

    }
}