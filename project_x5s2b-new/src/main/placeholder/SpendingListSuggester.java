package placeholder;

import static java.lang.Integer.valueOf;

public class SpendingListSuggester extends Subject {
    public SpendingList spendingList;


    public SpendingListSuggester() {
        spendingList = new SpendingList();

    }

    //REQUIRES: money i >= 0
    //MODIFIES: spendingList
    //EFFECTS: add money to the spendList and notifyObserves
    public void addMoneyToList(Double i) {
        this.spendingList.insert(i);
        notifyObservers(i);
    }



}
