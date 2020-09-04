package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.BankCard;
import placeholder.ImpossibleSituationException;
import placeholder.NegativeAmountException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DebitCardTest {

    public DebitCard dc;

    @BeforeEach
    public void setUp() throws IOException {
        dc = new BankCard ("Tina's card");
    }

    @Test
    public void testBalance() throws NegativeAmountException, ImpossibleSituationException {
        dc.spentMoney("100");
        assertEquals (9900,dc.balance());
        assertNotEquals (4100, dc.balance ());


    }

    @Test
    public void testSpentMoney() throws NegativeAmountException, ImpossibleSituationException {
        assertEquals(200,dc.spentMoney("200"));
        assertNotEquals(1000,dc.spentMoney("500"));
        assertEquals(0,dc.spentMoney("0"));
    }



}
