package Calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {

    @Before
    public void setUp(){
        TreeMap<java.lang.Integer, Monomial> m1 = new TreeMap<>();
        m1.put(0,new Monomial(0,new Integer(1)));
        m1.put(1,new Monomial(1,new Integer(1)));
        m1.put(2,new Monomial(2,new Integer(1)));
        m1.put(3,new Monomial(3,new Integer(1)));

    }

    @Test
    public void build(String s) {

    }

    @Test
    public void add() {
    }

    @Test
    public void mul() {
    }

    @Test
    public void evaluate() {
    }

    @Test
    public void derivative() {
    }

    @Test
    public void testToString() {
    }
}