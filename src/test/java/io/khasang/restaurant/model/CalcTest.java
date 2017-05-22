package io.khasang.restaurant.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

    @Before
    public void beforeAction() {
        System.out.println("Test start");
    }

    @Test
    public void testSum() {
        Calc calc = new Calc();
        Assert.assertNotNull(calc);
        Assert.assertEquals(5, calc.sum(2,3));
    }

    @After
    public void afterAction() {
        System.out.println("Test end");
    }
}
