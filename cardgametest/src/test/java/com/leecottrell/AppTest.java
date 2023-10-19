package com.leecottrell;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    //test the deal
    @Test
    public void TestDealSuitCountIsThirteen(){
        //setup
        Card aCard = new Card();
        int expected[] = {13,13,13,13};
        int actual[] = {0,0,0,0};

        //do the logic
        for(int x=0; x < 52; x++){
            aCard.pickCard();
            if(aCard.getSuit().equals("Hearts")){
                actual[0] ++;
            }
            else if(aCard.getSuit().equals("Diamonds")){
                actual[1] ++;
            }
            else if(aCard.getSuit().equals("Clubs")){
                actual[2] ++;
            }
            else if(aCard.getSuit().equals("Spades")){
                actual[3] ++;
            }
            else{
                assert(false);
                //bad suit//immediate fail
            }
        }//end for

        //assert the check
        assertArrayEquals(expected, actual);
    }


    //check card count
    @Test
    public void Test_Card_Count_Should_Be_4(){
        Card aCard = new Card();
        int expected[] = {4,4,4,4,4,4,4,4,4,4,4, 4, 4};//13 fours
        int actual[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};//13 zero

        for(int x=0; x < 52; x++){
            aCard.pickCard();
            actual[aCard.getValue()-1]++;
        }        

        assertArrayEquals(expected, actual);
    }


}
