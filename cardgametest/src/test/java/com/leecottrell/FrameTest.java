package com.leecottrell;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.*;

import org.junit.*;

/**
 * Unit test for simple Frame.
 */
public class FrameTest {
    public  JFrameCardGame theFrame = new JFrameCardGame();
    private javax.swing.JButton btnDeal;
    private javax.swing.JButton btnHigh;
    private javax.swing.JButton btnLow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWin;
    private javax.swing.JList lstCards;
    
    @Ignore
    public void RigorousTest(){
        assertTrue(true);
    }

    @Before
    public void SetupFrame(){
        theFrame = new JFrameCardGame();
        theFrame.setVisible(true);

        btnDeal = theFrame.btnDeal;
        btnHigh = theFrame.btnHigh;
        btnLow = theFrame.btnLow;
        lblWin = theFrame.lblWin;
    }

    @Test
    public void TestBtnHigh(){
        //unit test
        //test that something is written into the lblWin
        btnHigh.doClick();//click the button
        String actual = theFrame.lblWin.getText();

        assertFalse(actual.isBlank());
    }

    @Test
    public void FrameIsVisible(){
        assertTrue(theFrame.isVisible());
    }

    @Test
    public void BtnNewDealClearsListDealsOneCard(){
        //setup add cards to the list
        theFrame.cards.addElement(new Card("Hearts", 2));
        theFrame.cards.addElement(new Card("Hearts", 2));
        int actual;
        int expected = 1;

        theFrame.btnDeal.doClick();

        actual = theFrame.cards.getSize();
        assertEquals(expected, actual);
    
    }

    //functional testing
    @Test
    public void BtnHighChecksCardsProperly(){
        Card lastCard = new Card("Hearts", 2);
        Card newCard = new Card("Hearts", 5);

        theFrame.lastCard =lastCard;
        theFrame.newCard = newCard;
        theFrame.displayWin(theFrame.checkBet(1));//1 is high

        String expected= "Good";
        String actual = theFrame.lblWin.getText();
        assertEquals(expected, actual);
    }

    @Test
    public void EqualIsBadWithLowBet(){
        Card lastCard = new Card("Hearts", 5);
        Card newCard = new Card("Hearts", 5);
        theFrame.lastCard =lastCard;
        theFrame.newCard = newCard;
        theFrame.displayWin(theFrame.checkBet(2));//2 is low
        String expected= "Bad";
        String actual = theFrame.lblWin.getText();
        assertEquals(expected, actual);
    }
    @Test
    public void EqualIsGoodWithHighBet(){
        Card lastCard = new Card("Hearts", 5);
        Card newCard = new Card("Hearts", 5);
        theFrame.lastCard =lastCard;
        theFrame.newCard = newCard;
        theFrame.displayWin(theFrame.checkBet(1));//1 is low
        String expected= "Good";
        String actual = theFrame.lblWin.getText();
        assertEquals(expected, actual);
    }

    @Test
    public void WinnerConditionIsValid(){
        Card aCard = new Card("Hearts", 3);
        
        for(int x=1; x <= 7; x++){
            theFrame.cards.addElement(aCard);
            theFrame.displayWin(true);
        }

        String expected = "Winner";
        String actual = theFrame.lblWin.getText();
        assertEquals(expected, actual);
    }

}
