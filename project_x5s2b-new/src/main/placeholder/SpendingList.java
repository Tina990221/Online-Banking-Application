package placeholder;

import java.util.ArrayList;
import java.util.List;

// it represents a list of data(spending money)
public class SpendingList {

    public List<Double> spendList;

//    private String name;




    //EFFECTS: the list is empty
    public SpendingList() {
        spendList = new ArrayList<>();

    }




//    public void printSpendingList() {
//        System.out.println("Recent transaction : " + spendList.size() + "times");
//        for (Double x: spendList) {
//            System.out.println("-" + x + "dollars\n");
//        }
//    }

    //EFFECTS: returns true if i is in the spendinglist and false otherwise
    public boolean contains(Double i) {
        return spendList.contains(i);
    }


    //MODIFIES: this
    //EFFECTS: the spendingmoney i is added to the spendinglist if it's not
    //         already in the spendinglist
    public void insert(Double x) {
        spendList.add(x);



    }

    //EFFECTS: return the number of items in the spendingList
    public int size() {
        return spendList.size();
    }



}
