package Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTest {
    private Scalar test0;
    private Scalar testp6;
    private Scalar testp5;
    private Scalar testn7;
    private Scalar testn2;

    @Before
    public void setUp()  {
        test0= new Integer(0);
        testp6= new Integer(6);
        testp5= new Integer(5);
        testn7= new Integer(-7);
        testn2= new Integer(-2);
    }
    @Test
    public void testToString() {
        assertEquals("toString is wrong", "6",testp6.toString());
        assertEquals("toString is wrong", "-2",testn2.toString());
        assertEquals("toString is wrong", "0",test0.toString());
    }
    @Test
    public void testAdd() {
        Integer expected1 = new Integer(-2);
        Integer expected2 = new Integer(-9);
        assertEquals((Object) expected1, (Object) testp5.add(testn7));
        assertEquals((Object) expected1, (Object) testn2.add(test0));
        assertEquals((Object) expected2, (Object) testn7.add(testn2));
    }
    @Test
    public void testMul() {
        Integer expected1 = new Integer(0);
        Integer expected2 = new Integer(-35);
        Integer expected3 = new Integer(14);
        assertEquals((Object) expected1, (Object) test0.mul(testp6));
        assertEquals((Object) expected2, (Object) testp5.mul(testn7));
        assertEquals((Object) expected3, (Object) testn7.mul(testn2));
    }

    @Test
    public void testNeg() {
        Integer expected1 = new Integer(0);
        Integer expected2 = new Integer(-5);
        Integer expected3 = new Integer(7);
        assertEquals((Object) expected1, (Object) test0.neg());
        assertEquals((Object) expected2, (Object) testp5.neg());
        assertEquals((Object) expected3, (Object) testn7.neg());
    }

    @Test
    public void testPower() {
        Integer expected1 = new Integer(1);
        Integer expected2 = new Integer(49);
        Integer expected3 = new Integer(1);
        assertEquals((Object) expected1, (Object) testp6.power(0));
        assertEquals((Object) expected2, (Object) testn7.power(2));
        assertEquals((Object) expected3, (Object) testn2.power(0));
    }

    @Test
    public void testSign() {
        java.lang.Integer expected1= 0;
        java.lang.Integer expected2= 1;
        java.lang.Integer expected3= -1;
        assertEquals((Object) expected1, (Object) test0.sign());
        assertEquals((Object) expected2, (Object) testp5.sign());
        assertEquals((Object) expected3, (Object) testn7.sign());
    }
}