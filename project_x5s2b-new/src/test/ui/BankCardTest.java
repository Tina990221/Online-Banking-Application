package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.*;


import java.io.IOException;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class BankCardTest {

    private BankCard bankCard;
    public SpendingList list;
    private Main main;
    private Map<String, List<Double>> transactions = new HashMap<> ();
    public ShareMethod shareMethod;


    @BeforeEach
    public void setUp() throws IOException {
        bankCard = new BankCard ("Tina's card");
        shareMethod = new ShareMethod ();
    }


//    @Test
//    public void testaddNewSpending(String name){
//        List<Double> spendList = new ArrayList<>();
//        spendList.add(200.0);
//        transactions.put(name,spendList);
//        assertFalse (transactions.isEmpty ());
//    }

    @Test
    public void testEquals() {
        BankCard x = new BankCard ("Tina's card");  // equals and hashCode check name field value
        BankCard y = new BankCard ("Tina's card");
        assertTrue(bankCard.equals (x));
        assertTrue(y.equals (x));
        assertTrue(x.equals (y));
        assertTrue(x.hashCode() == y.hashCode());
    }



    @Test
    public void testEqualsfalse() {
        BankCard x = new BankCard ("Tina's card");  // equals and hashCode check name field value
        BankCard y = null;
        assertFalse(bankCard.equals (y));
    }

    @Test
    public void testEqualsTrue() {

        BankCard o = new BankCard ("Tina's card");  // equals and hashCode check name field value
        this.bankCard = o;
        assertTrue(bankCard.equals (o));
    }



    @Test
    public void testHashcode() {
        BankCard p1 = new BankCard ("Tina's card");
        Map<BankCard, Double> transactions = new HashMap<> ();
        transactions.put(p1, 200.0);
        assertEquals(200.0,transactions.get(p1));
    }


    @Test
    public void testaddNewSpending() {
        BankCard p1 = new BankCard ("Tina's card");
        Map<BankCard, Double> transactions = new HashMap<> ();
        p1.addNewSpending ("Tina");
        assertEquals(null,transactions.get(p1));
        transactions.put(p1, 200.0);
        assertEquals(200.0,transactions.get(p1));
    }




    //Test the balance of the card when spending money
    @Test
    public void testBalance() throws NegativeAmountException, ImpossibleSituationException {
        assertEquals(200, bankCard.spentMoney("200"));
        assertNotEquals (5500, bankCard.balance ());
        assertEquals (9800, bankCard.balance());


    }

    @Test
    public void testspentMoney(){
        try {
            assertEquals(200.00, bankCard.spentMoney("200"));
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        try {
            assertFalse(2500 == bankCard.spentMoney("1200"));
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
    }




//    @Test
//    public void testAddMoneyToList(){
//        goCard.addMoneyToList(12.65);
//        goCard.addMoneyToList(20.00);
//        assertEquals (2,list.size());
//
//    }

//    @Test
//    public void testShowList(){
//        goCard.addMoneyToList(12.65);
//        assertEquals (1,list.size());
//
//    }

    @Test
    public void testMoneyToPoints(){
        try {
            bankCard.spentMoney("200");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        bankCard.moneyToPoints();
        assertEquals(1470, bankCard.getPoints());
        try {
            bankCard.spentMoney("1000");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        bankCard.moneyToPoints();
        assertEquals(2790, bankCard.getPoints());

    }

    @Test
    public void testgetPoints(){
        bankCard.myAmount = 8000;
        bankCard.moneyToPoints();
        assertEquals (1200, bankCard.getPoints ());
        assertFalse (bankCard.getPoints() == 500);
        bankCard.moneyToPoints();
        try {
            bankCard.spentMoney("1000");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        assertEquals(2400, bankCard.getPoints());


    }


    @Test
    public void testMoviesEarned(){
        bankCard.myAmount = 8000;
        bankCard.moneyToPoints();
        assertEquals(1, bankCard.moviesEarned());
        try {
            bankCard.spentMoney("1000");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        bankCard.moneyToPoints();
        assertEquals (2, bankCard.moviesEarned());

    }

    @Test
    public void testfreeMoviesCalculator(){
        bankCard.myAmount = 8000;
        bankCard.moneyToPoints();
        assertEquals(1,bankCard.moviesCalculator ());
        try {
            bankCard.spentMoney("1000");
        } catch (NegativeAmountException e) {
            fail();
        } catch (ImpossibleSituationException e) {
            fail();
        }
        bankCard.moneyToPoints();
        assertEquals (2, bankCard.moviesCalculator());

    }

//    @Test
//    public void testsave() throws IOException {
//        List<String> lines = Files.readAllLines (Paths.get ("./data/GoCard.txt"));
//        int size = lines.size ();
//
//        assertEquals (size, goCard.load ().size ());
//        goCard.getLines().add ("spentmoney 20");
//        goCard.getLines().add ("spentmoney 40");
//        goCard.load();
//        goCard.save();
//        lines = Files.readAllLines (Paths.get ("./data/GoCard.txt"));
//        assertEquals(size + 2,lines.size());
//
//
//
//    }
//
//    @Test
//    public void testload() throws IOException {
//        List<String> lines = Files.readAllLines (Paths.get ("./data/GoCard.txt"));
//        int size = lines.size ();
//        assertEquals (size, goCard.load ().size ());
//
//        goCard.getLines().add ("spentmoney 30");
//        goCard.save ();
//        assertEquals(++size, goCard.load ().size());
//
//    }

//    @Test
//    public void testcardIsValid(){
//        shareMethod.within6months = false;
//        bankCard.within6months = false;
//
//
//        assertFalse(bankCard.cardIsValid () == true);
//        assertTrue(bankCard.cardIsValid () == false);
//
//        bankCard.within6months = true;
//        assertFalse(bankCard.cardIsValid () == false);
//        assertTrue(bankCard.cardIsValid () == true);
//
//    }

    // below are the tests for exception
    @Test
    public void testmoneyNegativeAmountException(){
        try {
            bankCard.spentMoney ("-900");
            fail("Exception was not thrown!");
        } catch (NegativeAmountException e) {
            //expected;
        } catch (ImpossibleSituationException e) {
           fail("wrong exception thrown: ImpossibleSituation Exception" );
        }

    }

    @Test
    public void testmoneyImpossibleSituationException(){
        try {
            bankCard.spentMoney ("10000000");
            fail("Exception was not thrown!");
        } catch (NegativeAmountException e) {
            fail("wrong exception thrown: NegativeAmount Exception" );
        } catch (ImpossibleSituationException e) {
            //expected
        }
    }

    @Test
    public void testupdate1(){

        bankCard.update(200.0);
        assertEquals(1,bankCard.time);


    }

    @Test
    public void testupdate2(){

        bankCard.update(200.0);
        assertEquals(1,bankCard.time);
        bankCard.update(300.0);
        assertEquals(2,bankCard.time);



    }


}




