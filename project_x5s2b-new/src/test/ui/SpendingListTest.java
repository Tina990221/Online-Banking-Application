package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.SpendingList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class SpendingListTest {

    private static final double NUMBER = 1000;
    public SpendingList list; //Spendinglist要用到list


    @BeforeEach
    public void runBefore(){
        list = new SpendingList ();//用了list
    }

    @Test
    public void testSize(){
        assertEquals(0, list.size());

        for (int i = 0; i < NUMBER; i++){
            list.insert((double)i);
        }

        assertEquals(NUMBER, list.size());

    }
    @Test
    public void testContainsOne(){
        assertFalse(list.contains((double)1));
        list.insert((double)1);
        assertTrue(list.contains((double)1));
    }

    @Test
    public void testContainslots(){
        for(int i = 0; i < NUMBER; i++){
            list.insert((double)i);
        }

        for (int i = 0; i < NUMBER; i++){
            assertTrue(list.contains((double)i));
        }
    }

    @Test
    public void testInsertmany(){
        for (double i = 0; i < NUMBER; i++){
            list.insert(i);
        }

        assertTrue(list.contains((double)0));
        assertTrue(list.contains(NUMBER / 2));
        assertTrue(list.contains(NUMBER - 1));
        assertFalse(list.contains(NUMBER + 1));
        assertEquals(NUMBER, list.size());
    }

    @Test
    public void testInsertone() {
        list.insert ((double)1);
        assertTrue (list.contains ((double)1));
        assertEquals (1, list.size ());
    }

    @Test
    public void testDuplicate(){
        list.insert((double)1);
        list.insert((double)1);

        assertTrue(list.contains((double)1));
        assertEquals((double)2,list.size());

    }





}
