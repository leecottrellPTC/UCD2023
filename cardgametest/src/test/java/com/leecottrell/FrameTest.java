package com.leecottrell;

import static org.junit.Assert.assertArrayEquals;
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
        btnHigh.doClick();
        Card lastCard = theFrame.lastCard;
        Card newCard = theFrame.newCard;
        //lastCard.getValue

        String expected;
        if(newCard.getValue() <= lastCard.getValue()){
            expected = "Bad";
        }
        else{
            expected = "Good";
        }

        String actual = theFrame.lblWin.getText();
        assertEquals(expected, actual);

    }

    @Test
    public void FrameIsVisible(){
        assertTrue(theFrame.isVisible());
    }


}
