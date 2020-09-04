package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.BankCard;
import placeholder.ImpossibleSituationException;
import placeholder.NegativeAmountException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreditCardTest {

    public CreditCard cc;

    @BeforeEach
    public void setUp() throws IOException {
        cc = new BankCard ("Tina's card");
        }

    @Test
    public void testBalance(){
        try {
            cc.spentMoney("4000");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        assertEquals(6000,cc.balance());
        assertNotEquals (1200, cc.balance ());

    }

    @Test
    public void testgetPoints(){
        int initialAmount = 1000;
        assertEquals (0,cc.getPoints ());
        int initialAmount1 = 2000;
        assertFalse (cc.getPoints() == 34);
        assertFalse (cc.getPoints () == 30);
    }











}
