package placeholder;

public interface SpendingListObserver {

    //REQUIRES: money >= 0
    //MODIFIES: name, time
    //EFFECTS: add the times for transactions and update spending informaiton
    void update(Double money);
}
