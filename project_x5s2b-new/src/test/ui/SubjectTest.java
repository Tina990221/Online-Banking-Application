package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.BankCard;
import placeholder.SpendingListObserver;
import placeholder.SpendingListSuggester;
import placeholder.Subject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SubjectTest {

    public Subject subject;
    public List<SpendingListObserver> spendingListObservers;
    public BankCard bankCard;


    @BeforeEach
    public void setUp() {
       subject = new SpendingListSuggester ();
       spendingListObservers = new ArrayList<> ();


    }

    @Test
    public void testAddObserver(){
        bankCard = new BankCard ("Tina's Card");
        subject.addObserver (bankCard);
        assertEquals(1,subject.spendingListObservers.size());

    }

    @Test
    public void testAddObserverduplicate(){
        bankCard = new BankCard ("Tina's Card");
        subject.addObserver (bankCard);
        assertEquals(1,subject.spendingListObservers.size());
        subject.addObserver (bankCard);
        assertEquals(1,subject.spendingListObservers.size());

    }

    @Test
    public void testnotifyObservers1(){
        bankCard = new BankCard ("Tina's Card");
        assertEquals (0,bankCard.time);
        subject.addObserver (bankCard);
        subject.notifyObservers (200.0);
        assertEquals(1,bankCard.time);


    }

    @Test
    public void testnotifyObservers2(){
        bankCard = new BankCard ("Tina's Card");
        assertEquals (0,bankCard.time);
        subject.addObserver (bankCard);
        subject.notifyObservers (200.0);
        assertEquals(1,bankCard.time);
        subject.notifyObservers (150.0);
        assertEquals(2,bankCard.time);

    }



}
