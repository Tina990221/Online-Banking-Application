package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.SpendingListSuggester;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SpendingListSuggesterTest {
    public SpendingListSuggester spendingListSuggester;
    public List<Double> spendList;

    @BeforeEach
    public void setup(){
        spendingListSuggester = new SpendingListSuggester();
        spendList = new ArrayList<>();


    }

    @Test
    public void testAddMoneyToList(){
        spendingListSuggester.addMoneyToList(12.65);
        spendingListSuggester.addMoneyToList(20.00);
        assertFalse(spendList.size() == 2);

    }

    @Test
    public void testShowList(){
        spendingListSuggester.addMoneyToList(12.65);
        assertFalse (1 ==spendList.size());

    }

}
