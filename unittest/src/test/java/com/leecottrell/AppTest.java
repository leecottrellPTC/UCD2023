package com.leecottrell;

import static org.junit.Assert.*;

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
        assertTrue( false );
    }

    @Test
    public void testAddEm(){
        //configure environment
        int a = 5;
        int b = 6;
        int expected = 101;
        SimpleClass instance = new SimpleClass();

        //run the method to be tested
        int actual = instance.addEm(a, b);
        //assert the results

        assertEquals("Function addem", expected, actual);

    }

    @Test
    public void testdivEm(){
        //configure environment
        int a = 15;
        int b = 3;
        float expected = 5;
        SimpleClass instance = new SimpleClass();

        //run the method to be tested
        float actual = instance.divEm(a, b);
        //assert the results

       // assertEquals("Function addem", expected, actual);
        assertEquals(expected, actual, 0.01);

    }
}
