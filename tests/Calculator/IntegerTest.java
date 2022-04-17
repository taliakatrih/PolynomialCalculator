package Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTest {
    private Scalar testp1;
    private Scalar testp2;
    private Scalar testp3;
    private Scalar testp4;

    @Before
    public void setUp()  {
        testp1= new Integer(26);
        testp2= new Integer(5);
        testp3= new Integer(7);
        testp4= new Integer(-2);
    }
    @Test
    public void testToString() {
        assertEquals("toString is wrong", "26",testp1.toString());
    }
    @Test
    public void add() {
        Integer expected = new Integer(12);
        assertEquals((Object) expected, (Object) testp2.add(testp3));
    }
    @Test
    public void Add1() {
    }

    @Test
    public void testAdd1() {
    }

    @Test
    public void mul() {
    }

    @Test
    public void testMul() {
    }

    @Test
    public void testMul1() {
    }

    @Test
    public void neg() {
    }

    @Test
    public void power() {
    }

    @Test
    public void sign() {
    }
}