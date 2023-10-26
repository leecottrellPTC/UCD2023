package com.leecottrell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Ignore
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    static Physics test;
    @BeforeClass
    public static void setupTest(){
        test = new Physics();
    }

    @Test
    public void testAvgVelocity1020(){
        test.setV0(10);
        test.setV1(20);
        double expected = 15;
        double actual = test.avgVelocity();

        assertEquals(expected, actual, .01);

    }
}
