package com.leecottrell;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Disabled
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

        assertEquals( expected, actual, "Function addem");

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

    //parameterized tests
    @ParameterizedTest
    @ValueSource(strings = {"Computer", "Happy", "People"})
    void stringIsNotNull(String word){
        assertNotNull(word);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -1, 2, 4, 0, 5, -6})
    void numIsPositive(int number){
        assertTrue(number > 0, number + " is not positive");
    }

    //send a CSV of values
    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "1, 1, 11",
        "15, 15, 30"
    })
    void testFunAddem(int a, int b, int expected){
        SimpleClass test = new SimpleClass();
        String message = String.format("%d + %d should be %d",a, b, expected);

        int actual = test.addEm(a, b);
        assertEquals(expected, actual, message);
    }


}
