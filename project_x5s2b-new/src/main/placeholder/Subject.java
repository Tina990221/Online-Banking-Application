package placeholder;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    public List<SpendingListObserver> spendingListObservers;


    public Subject() {
        spendingListObservers = new ArrayList<>();

    }


    //REQUIRES: the spendinglist observers does not contain the observers
    //EFFECTS: add the observer to the SpendingListObserver
    public void addObserver(SpendingListObserver o) {
        if (!spendingListObservers.contains(o)) {
            spendingListObservers.add(o);
        }


    }

    //REQUIRES: money >= 0
    //EFFECTS: Let every observers in the spendingListObservers to update information
    public void notifyObservers(Double money) {
        for (SpendingListObserver o : spendingListObservers) {
            o.update(money);
        }
    }
}




