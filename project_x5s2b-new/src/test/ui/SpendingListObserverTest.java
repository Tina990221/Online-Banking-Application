package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.BankCard;
import placeholder.ImpossibleSituationException;
import placeholder.NegativeAmountException;
import placeholder.SpendingListObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SpendingListObserverTest {

    public SpendingListObserver spendingListObserver;
    public BankCard bankCard;

    @BeforeEach
    public void setup(){
        spendingListObserver = new BankCard ("Tina's Card");
        bankCard = new BankCard ("Tina's Card");
    }


    @Test
    public void testupdate1() {
        spendingListObserver.update(200.0);
        bankCard.update(200.0);
        assertEquals (1,bankCard.time);

    }

    @Test
    public void testupdate2() {
        spendingListObserver.update(200.0);
        bankCard.update(200.0);
        assertEquals (1,bankCard.time);
        spendingListObserver.update(140.0);
        bankCard.update(140.0);
        assertEquals (2,bankCard.time);

    }


}
