package Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RationalTest {
    private Scalar test0;
    private Scalar test26;
    private Scalar testm34;
    private Scalar testm46;
    private Scalar testm39;

    @Before
    public void setUp(){
        test0= new Rational(0,1);
        test26= new Rational(2,6);
        testm34= new Rational(-3,4);
        testm46= new Rational(4,-6);
        testm39= new Rational(-3,-9);
    }

    @Test
    public void reduce() {
//        Rational expected1 = new Rational(0,0);
//        Rational expected2 = new Rational(-35);
//        Rational expected3 = new Rational(14);
////        assertEquals((Object) expected1, (Object) );
//        assertEquals((Object) expected2, (Object) test26.re);
//        assertEquals((Object) expected3, (Object) testn7.mul(testn2));
    }

    @Test
    public void testToString() {
        assertEquals("toString is wrong", "0",test0.toString());
        assertEquals("toString is wrong", "-4/6",testm46.toString());
        assertEquals("toString is wrong", "-3/4",testm34.toString());
        assertEquals("toString is wrong", "3/9",testm39.toString());
    }

    @Test
    public void testAdd() {
        Rational expected1 = new Rational(2,6);
        Rational expected2 = new Rational(-3,4);
        Rational expected3 = new Rational(-34,24);
        assertEquals((Object) expected1, (Object) test0.add(test26));
        assertEquals((Object) expected2, (Object) test0.add(testm34));
        assertEquals((Object) expected3, (Object) testm34.add(testm46));
    }
    @Test
    public void testMul() {
        Rational expected1 = new Rational(0,1);
        Rational expected2 = new Rational(-6,24);
        Rational expected3 = new Rational(-12,54);
        assertEquals((Object) expected1, (Object) test0.mul(test26));
        assertEquals((Object) expected2, (Object) test26.mul(testm34));
        assertEquals((Object) expected3, (Object) testm46.mul(testm39));
    }


    @Test
    public void testNeg() {
        Rational expected1 = new Rational(0,1);
        Rational expected2 = new Rational(-2,6);
        Rational expected3 = new Rational(-3,9);
        Rational expected4 = new Rational(3,4);
        assertEquals((Object) expected1, (Object) test0.neg());
        assertEquals((Object) expected2, (Object) test26.neg());
        assertEquals((Object) expected3, (Object) testm39.neg());
        assertEquals((Object) expected4, (Object) testm34.neg());
    }

    @Test
    public void testPower() {
        Rational expected1 = new Rational(0,1);
        Rational expected2 = new Rational(16,36);
        Rational expected3 = new Rational(9,81);
        Rational expected4 = new Rational(1,1);
        assertEquals((Object) expected1, (Object) test0.power(1));
        assertEquals((Object) expected2, (Object) testm46.power(2));
        assertEquals((Object) expected3, (Object) testm39.power(2));
        assertEquals((Object) expected4, (Object) testm34.power(0));
    }

    @Test
    public void testSign() {
        java.lang.Integer expected1= 0;
        java.lang.Integer expected2= 1;
        java.lang.Integer expected3= -1;
        assertEquals((Object) expected1, (Object) test0.sign());
        assertEquals((Object) expected3, (Object) testm46.sign());
        assertEquals((Object) expected2, (Object) testm39.sign());
        assertEquals((Object) expected3, (Object) testm34.sign());
    }
}